FROM python:3.12 as python-base

RUN mkdir chatbot
WORKDIR /chatbot
COPY . /chatbot
RUN pip install --upgrade pip
RUN pip install -r requirements.txt

CMD ["gunicorn", "-c", "gunicorn.config.py"]
EXPOSE 8000