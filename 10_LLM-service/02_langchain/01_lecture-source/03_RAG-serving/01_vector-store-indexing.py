# page 1

# 콘솔에서 'conda activate pystudy_env' 키워드로 콘솔환경 설정 - 여러 모델을 쓸 수 있는 환경 
# 파이썬은 콘솔과 코드상의 싱크가 자동을 맞춰주지 않기 때문에 수동으로 맞춰줘야한다.
#       - ctrl + shit + p -> interpreter -> pystudy_env 선택
# 콘솔환경에서 실행 방법 :
#       1. 해당 파일이 있는 폴더로 이동한다. 2. >python [파일명]
# faiss db 설치: pip install faiss-cpu

# import 전에 라이브러리 명이 초록색으로 변해야 올바른 라이브러리명을 작성한거다
from dotenv import load_dotenv # Lang Smith
from langchain_community.document_loaders import PyPDFLoader # PDF 로더 설정 및 초기화
from langchain_openai import OpenAIEmbeddings
from langchain_text_splitters import RecursiveCharacterTextSplitter
from langchain_community.vectorstores import FAISS # FAISS db 사용
from langchain_community.vectorstores.utils import DistanceStrategy

# Lang Smith 연결
load_dotenv(dotenv_path="../99_env/.env")

# PDF 로더 설정 및 초기화
loader = PyPDFLoader("./test.pdf")

# 문서 읽기
documents = loader.load()

# 임베딩 모델 로드
embedding_model = OpenAIEmbeddings()

# 문서 분할
text_splitter = RecursiveCharacterTextSplitter(chunk_size=100, chunk_overlap=10)
texts = text_splitter.split_documents(documents)

for text in texts:
    print(text)
    

# 
vectorstore = FAISS.from_documents(
    texts,
    embedding=embedding_model, # 벡터스토어에 저장할 때 embedding_model로 저장한다.
    distance_strategy=DistanceStrategy.COSINE # 거리기반으로 유사도 검사 시 COSINE 유사도를 사용하여 판별한다.
)

vectorstore.save_local('./db/faiss')