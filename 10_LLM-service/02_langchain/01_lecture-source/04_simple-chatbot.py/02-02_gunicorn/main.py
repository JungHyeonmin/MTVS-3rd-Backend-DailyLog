from fastapi import FastAPI
import time

app = FastAPI()

@app.get("/test")
async def test():
    
    time.sleep(5) # 5초동안 정지
    print("hello?")

    return "hello world!"

# gunicorn : uvicorn같은 프로세스를 여러개 사용할 수 있도록 해주는 툴
# docker : 복잡한 설정을 간단하게 해주는 툴, 프로세스를 격리시키기 위한 컨테이너 시스템