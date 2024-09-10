# worker : 프로세스의 개수

import multiprocessing

workers = multiprocessing.cpu_count() * 2 + 1 # 쓰레드같은 녀석의 개수를 사전에 정의할 수 있다. # 코어개수 * 2 + 1은 공식 문서에 나와있는 내용이다.
print(workers)
worker_class ="uvicorn.workers.UvicornWorker" # 유비콘을 사용할때 uvicornWorker를 사용한다.
wsgi_app = "02_simple-chatbot-serving:app"
loglevel="info"
bind="0.0.0.0:8000"
max_requests=1 # 프로세스 하나당 처리할 수 있는 개수. 지정하지 않으면 무제한적으로 받는다.
keepalive=0 # 브라우저로 서버를 요청을 하면 자동으로 keepalive가 요청된다. 프로세스를 실행할 때 요청상태를 잠깐동안 유지한다. 0으로 설정하면 껏다 키면 요청이 사라진다.

# -> 도커 이미지 만들어보기- 확장자 없이 사용한다.

# 