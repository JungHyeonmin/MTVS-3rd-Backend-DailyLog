from dotenv import load_dotenv
from fastapi import FastAPI
from langchain_openai import OpenAIEmbeddings
from langchain.chat_models import ChatOpenAI
import uuid
from langchain_community.vectorstores import FAISS
from langchain_community.vectorstores.utils import DistanceStrategy
from langchain.docstore.document import Document
from typing import Annotated
from fastapi import Form
import os
import shutil
from langchain.memory import VectorStoreRetrieverMemory
from langchain.chains import ConversationChain


# 환경변수란?
# 운영체제가 가지고 있는 변수

# 환경 변수 로드
load_dotenv()

# fastapi app 생성
app = FastAPI()

# 임베딩 모델 로드
embedding_model = OpenAIEmbeddings()

# LLM 모델 로드
model = ChatOpenAI(
    model = "gpt-4o-mini",
    temperature = 0.3  
)

@app.post("/init-conversation")
async def init_conversation():
    
    # uuid : 겹쳐지지 않은 난수를 발생시키는 방법(cd-key같은거를 만들때 사용한다.), 문자열이 아니다..
    # uuid4 : 랜덤으로 만든다는 뜻
    conversation_session_id = str(uuid.uuid4())
    
    print(conversation_session_id)
    
    # 벡터 스토어
    vectorstore = FAISS.from_documents(
        # 저장할 데이터, 임베딩 모델, 벡터스토어 사용 방식
        # Document : 데이터와 메타데이터가 있는 객체
        [Document(page_content="대화를 시작합니다.")],
        embedding = embedding_model,
        distance_strategy = DistanceStrategy.COSINE
    )
    
    # 벡터스토어를 사용하려면 어떤 디렉토리에서 만들건지 지정해줘야한다.
    vectorstore.save_local('./db/' + conversation_session_id)

    return conversation_session_id


@app.delete("/remove_conversation")
async def remove_conversation(conversation_session_id: Annotated[str, Form()]):
    
    index_file_path = './db/' + conversation_session_id
    
    if os.path.exists(index_file_path):
        shutil.rmtree(index_file_path, ignore_errors=True) # rmtree : 강제적으로 하위 디렉토리를 지운다. ignore_error: 에러 무시
        print(f"index file {index_file_path} has been removed")
    else:
        print(f"index file {index_file_path} does not exist.")

    return "remove ok"


@app.post("/conversation")
async def conversation(conversation_session_id: Annotated[str, Form()], conversation_text: Annotated[str, Form()]):
    
    vectorstore = FAISS.load_local(
        "./db/" + conversation_session_id, # 위치
        embedding_model, # 임베딩 모델
        allow_dangerous_deserialization=True # 저장되어 있는 내용을 복호화할 때 위험성을 알고 있는지 물어본다.
    )
    
    retriever = vectorstore.as_retriever(
        search_type="similarity",
        search_kwargs={"k" : 5}
    )
    
    memory = VectorStoreRetrieverMemory(retriever = retriever)
    
    conversation_chain = ConversationChain(
        llm = model,
        memory = memory
    )
    
    conversation_response = conversation_chain.predict(input=conversation_text)
    
    vectorstore.add_documents(
        [
            Document(page_content="human:" + conversation_text+"\nAI:" + conversation_response) # 질문과 응답이 분리되지 않도록 해준다.
        ]
    )
    
    vectorstore.save_local("./db/" + conversation_session_id)
    
    return conversation_response