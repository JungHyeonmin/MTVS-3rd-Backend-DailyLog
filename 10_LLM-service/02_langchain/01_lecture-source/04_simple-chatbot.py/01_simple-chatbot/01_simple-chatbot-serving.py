# ollama serve : ollama 켜기

from dotenv import load_dotenv
load_dotenv(dotenv_path="../99_env/.env")

from langchain.memory import ConversationBufferMemory

conversation_buffer_memory = ConversationBufferMemory(return_message = True)
conversation_buffer_menory.save_context(
    inputs={
        "human":"안녕하세요 저는 백엔드 개발자로 취업을 하고 싶은 취업 준비생입니다. 무엇을 어떻게 준비해야 할까?"
    },
    outputs={
        "ai":"안녕하세요. 백엔드 개발자로 취업을 준비하고 계시는 군요. 먼저 현재의 상태와 목표에 대해 구체적으로 말씀해주시겠어요?"
    }
)

conversation_buffer_memory.save_context(
    inputs={
        "human" : "저는 30살이고, 비전공자입니다. 6개월 정도 교육을 받은 후 최대한 빠르게 취업을 하고 싶은 방향만 가지고 있습니다." 
    },
    outputs={
        "ai: " : """비전공자로 백엔드 개발자로 취업하기에 불가능한 영역은 아니지만 매우 많은 노력이 필요합니다.
        먼저 6개월간의 공부 내용을 충분히 숙지할 수 있도록 매일 20시간 이상 공부하시며, 다양한 프로젝트 경험을 쌓는 것이 좋은 방향입니다.
        """
    }
)

conversation_history = conversation_buffer_memory.load_memory_variables({})
print(conversation_history["history"])


from langchain.chat_models import ChatOllama
from langchain.chains import ConversationChain # 저장해야 하는 챗봇을 만들때 사용한다.

model = ChatOllama(
    model="gemma2:2b",
    temperature=0.3
)

# 체인을 만들때 모델에 메모리를 붙여서 만든다.
conversation_chain = ConversationChain(
    llm = model,
    memory=ConversationBufferMemory() # 대화 내용을 저장할 공간 생성
)

answer = conversation_chain.predict(
    input="안녕하세요 저는 백엔드 개발자로 취업을 하고싶은 취업 준비생입니다. 무엇을 어떻게 준비해야 할까요?"
)
print(answer)

answer = conversation_chain.predict(
    input="웹개발에 관심이 있고  java를 배우고 싶습니다."
)
print(answer)

# TO-DO LIST로 만들어 보기
answer = conversation_chain.predict(
    input="할일이 너무 많은거 같은데 해야 할 일을 한국어로 TO-DO List 형태로 만들어 다오"
)
print(answer)


# 이런식으로 만들면 메모리에만 존재하기 때문에 프로그램을 종료하면 사라진다
# 여러 사용자가 사용하면 하나의 프로세스에서만 사용하기 때문에 다른 사람과 구분하지 못한다. -> 점점 이상해진다.
# 