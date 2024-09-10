# Docker 이미지를 만드는 설정 파일. 이대로 이미지가 생성된다.

# 맨 윗줄은 FROM문 작성한다. 파이썬 버전으로 베이스 이미지를 설정하겠다. -> 우분투와 파이썬까지 설치하고 시작하겠다는 뜻
FROM python:3.12 as python-base

# 순서대로 동작하는 RUN

# mkdir : 파일 생성
RUN mkdir gunicorn-test

# WKRKDIR: 해당 폴더를 작업 directory로 설정
WORKDIR /gunicorn-test

# COPY: 파일을 복사해서 넣는다.
COPY . /gunicorn-test

# gunicorn 설치
RUN pip install gunicorn fastapi["all"]

# CMD : 최종적으로 실행할 커멘드를 작성 - 커멘드단 위로 띄어쓰기를 한다.
CMD ["gunicorn", "-c", "gunicorn.config.py"]

#EXPOSE : 포트번호
EXPOSE 8000


# 도커 이미지의 이름은 버전(태그이름)까지 들어가야한다. 버전을 입력하지 않으면 최신버전으로 알아서 작성해준다.
# -> 도커파일이미지가 있는 위치로 이동 후 docker build -t gunicorn-server . 
#   -> 다운로드 후 docker imgages로 확인하기

# 도커를 사용하면 유비콘 설정한거를 