# page2

# 첫번째 임베딩 모델과 두번째 임베딩 모델이 같아야한다.

from dotenv import load_dotenv # Lang Smith
from langchain_openai import OpenAIEmbeddings
from langchain_community.vectorstores import FAISS
from langchain_core.prompts import ChatPromptTemplate
from langchain_community.chat_models import ChatOllama
from langchain_core.runnables import RunnablePassthrough

# Lang Smith 연결
load_dotenv(dotenv_path="../99_env/.env")

# 임베딩 모델 로드
embedding_model = OpenAIEmbeddings()

# Local FAISS 로드
vectorstore = FAISS.load_local(
    "./db/faiss",
    embedding_model,
    allow_dangerous_deserialization=True
)

# retriever 생성
retriever = vectorstore.as_retriever(
    search_type="similarity",
    search_kwargs={"k":5}
)

# print(retriever.batch(["빵"]))

# prompt 생성
message = """
Answer this question using the provided context only

{question}

Context:
{context}
"""

# prompt 템플릿 생성
prompt = ChatPromptTemplate.from_messages(
    [
        ("system", "당신은 어린 아이에게 아주 친절한 유치원 선생님 입니다. 질문하는 아이의 동심이 파괴되지 않게 잘 답변을 해주세요."),
        ("human", message)
    ]
)


# LLM 모델 로드
model = ChatOllama(
    model = "gemma2:2b",
    temperature=0.3
)

# RAG chain 생성
chain = {"context": retriever, "question" : RunnablePassthrough()} | prompt | model

# print(chain.invoke("백설공주의 이름이 왜 백설공주야?"))



# FAST API로 서빙하기!!!

# FAST API 설치 명령어 : pip install fastapi["all"]

from fastapi import FastAPI, Form
from typing import Annotated

app = FastAPI()

@app.post("/snow-white", tags=["백설공주"]) # import 필요
async def snow_white(question: Annotated[str, Form()]): # import 필요
    return {"answer": chain.invoke(question).content}

# 서버 여는 명령어 : uvicorn [파일명]:app --reload