package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {

        // reflect란?
        // 컴파일 된 자바 코드에서 역으로 클래스를 불러 메서드 및 필드 정보를 구해오는 방법을 제공한다.
        // 반사, 투영이라는 의미를 가진다.
        // 스프링, 마이바이트, 하이버네이트, 등의 라이브러리에서 사용한다.

        // 주의사항
        // 1. 오버헤드 발생 : 성능 저하를 발생할 수 있기 때문에 성능에 민감한 애플리케이션은 사용하지 않는다.
        // 2. 캡슐화 저해 : private 로 설정한 member 에 직접적으로 접근이 가능하기 때문에 코드 기능이 저하되며 여러가지 문제를 야기한다.

        Class class1 = Account.class;
        System.out.println("class1 = " + class1);

        Class class2 = new Account().getClass();
        System.out.println("class2 = " + class2);


        try {
            //동적 로딩 (런타임 시 로딩)

            // forName() : 오타가 나올 수 있기 때문에 try/catch문으로 작성해야 한다.
            // 동적 로딩 (런타임 시 로딩)
            // 장점 : 런타임을 한 후에 로딩을 하기때문에 최초 실행속도가 빠르다.
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            Class class4 = Class.forName("[D");
            System.out.println("class4 = " + class4);

            Class class5 = double[].class;
            System.out.println("class5 = " + class5);

            Class class6 = Class.forName("[Ljava.lang.String;");
            System.out.println("class6 = " + class6);

            Class class7 = String[].class;
            System.out.println("class7 = " + class7);

            Class superClass = class1.getSuperclass(); // SuperClass : 부모클래스에 대한 정보를 반환받을 수 있다.
            System.out.println("superClass = " + superClass);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /** ⤵️이런게 가능하구나~ 정도만 들어라.. 작동이 되면 신기하다~⤵️
         * 스스로 만들고 보여줄 수 있다면 스프림을 잘 이해하고 있는 것이다.
         *  */
        // 필드 정보 반환
        Field[] fields = Account.class.getDeclaredFields();// 리턴타입이 필드라는 이름의 배열 클래스로 반환해준다.
        for (Field field : fields) {
            System.out.println("modifiers = " + Modifier.toString(field.getModifiers())); // modifier :
            System.out.println("type = " + field.getType());
            System.out.println("name = " + field.getName());
        }

        // 생성자 정보 확인
        Constructor[] constructors = Account.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("name : " + constructor.getName());
            Class[] params = constructor.getParameterTypes();
            for (Class param : params) {
                System.out.println("paramType = " + param.getTypeName());
            }
        }

        // Object 로 반환하기 때문에 다운캐스팅을 한다.
        try {
            Account acc = (Account) constructors[0].newInstance("20", "110-123-456789", "1234", 10000);
            System.out.println(acc.getBalance());

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 메소드 정보에 접근
        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null;

        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()) + " "
                    + method.getReturnType().getSimpleName() + " "
                    + method.getName());

            // method.getName().equals("getBalance"); : 위의 코드보다 이게 더 좋다.
            // 위의 코드는 런타임 중에 NullTimeException 을 못막는다.
            // 아래 코드는 방지할 수 있다.

            if ("getBalance".equals(method.getName())) {
                getBalanceMethod = method;
            }
        }

        try {
            System.out.println(getBalanceMethod.invoke((Account) constructors[2].newInstance()));

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }


    }
}
