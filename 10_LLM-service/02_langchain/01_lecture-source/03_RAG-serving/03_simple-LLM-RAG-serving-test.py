from dotenv import load_dotenv
from langchain_openai import OpenAIEmbeddings
from langchain_community.vectorstores import FAISS
from langchain_core.prompts import ChatPromptTemplate
from langchain_community.chat_models import ChatOllama
from langchain_core.runnables import RunnablePassthrough


from fastapi import FastAPI, Form
from typing import Annotated


load_dotenv(dotenv_path="../99_env/.env")

embedding_model = OpenAIEmbeddings()

vectorstore = FAISS.load_local(
    "./db/faiss",
    embedding_model,
    allow_dangerous_deserialization=True
)

retriever = vectorstore.as_retriever(
    search_type="similarity",
    search_kwargs={"k":5}
)


message = """
Answer this question using the provided context only

{question}

Context:
{context}
"""

prompt = ChatPromptTemplate.from_messages(
    [
        ("system", "당신은 어린 아이에게 아주 친절한 유치원 선생님 입니다. 질문하는 아이의 동심이 파괴되지 않게 잘 답변을 해주세요."),
        ("human", message)
    ]
)

model = ChatOllama(
    model = "gemma2:2b",
    temperature=0.3
)

chain = {"context" : retriever, "question" : RunnablePassthrough()} | prompt | model


app = FastAPI()

@app.post("/job", tags=["취준생 레츠고"])
async def job(question: Annotated[str, Form()]):
    return {"answer": chain.invoke(question).content}
