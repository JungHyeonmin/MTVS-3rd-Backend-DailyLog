import multiprocessing

# worker : 프로세스의 개수
workers = multiprocessing.cpu_count() * 2 + 1 # 서버에서 실행될 워커 프로세스의 개수를 정의한다. # 워커(쓰레드와 비슷함)의 수는 [코어 * 2 + 1]이다
# print(workers) # 코어 수 확인

# WSGI 서버이기 때문에 기본적으로 동기 작업을 한다. 하지만 ASGI 서버와 함께 사용할 때는 비동기 작업을 처리할 수 있도록 Uvicorn worker를 설정해야한다.
# Gunicorn이 비동기적인 Uvicorn 작업자와 함께 동작하게 됩니다.
worker_class ="uvicorn.workers.UvicornWorker" # 유비콘을 사용할때 uvicornWorker를 사용한다. # Uvicorn 워커를 사용하여 ASGI 서버를 실행할 때 사용된다.
                                              # ASGI 서버 : 비동기 웹 서버와 애플리케이션 간의 인터페이스를 정의하는 프로토콜. 동기적인(WSGI)의 한계를 극복했다.
wsgi_app = "main:app" # 실행할 파일 이름
loglevel="info"
bind="0.0.0.0:8000"
max_requests=1 # 프로세스 하나당 처리할 수 있는 개수. 지정하지 않으면 무제한적으로 받는다.
keepalive=0 # 브라우저로 서버를 요청을 하면 자동으로 keepalive가 요청된다. 프로세스를 실행할 때 요청상태를 잠깐동안 유지한다. 0으로 설정하면 껏다 키면 요청이 사라진다.

# -> 도커 이미지 만들어보기- 확장자 없이 사용한다.


# Guvicorn과 Uvicorn의 관계
## Guvicorn : 관리자 역할. 여러 worker 프로세스를 관리하는 프로세스 관리자 역할이다.
##          : 요청을 수신하고 이를 worker프로세스에 분배하여 병렬처리를 통해 서버의 성능을 향상시킨다.

## Uvicorn : ASGI 요청을 실제로 처리하는 작업자(worker). ASGI 서버로, FastAPI나 Starlette와 같은 ASGI 애플리케이션의 요청을 처리한다.
##         : Uvicorn은 비동기 요청을 처리할 수 있어, 웹소켓 같은 실시간 통신과 다수의 요청을 효율적으로 처리하는 데 적합하다.