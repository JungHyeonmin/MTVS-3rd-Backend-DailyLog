package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor") // 같은 @Service Bean 이지만 이름은 다르다.
public class BookService {

    private final BookDAO bookDAO;

    // -> 생성자 주입
    // 생성자에도 @Autowired 를 사용할 수 있다.
    // 그러면 스프링 컨테이너는 BookService bean 객체 생성 시 BookDAO 타입의 bean 객체를 찾아 의존성을 주입해준다.
    //스프링 버전 4부터는 생성자에 @Autowired 를 생략해도 된다. 하지만 생성자 2개 이상부터는 생략불가하다.

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> findAllBooks() {

        return bookDAO.findAllBooks();
    }

    public BookDTO searchBookBySequence(int seq) {

        return bookDAO.findBookBySeq(seq);
    }

    /**
     * **생성자 주입의 장점**
     *
     * - 객체가 생성 될 때 모든 의존성이 주입 되므로 의존성을 보장할 수 있다.
     *     - 필드 주입/세터 주입은 의존성이 있는 객체가 생성되지 않아도 객체 생성은 가능하여 메소드가 호출 되면(런타임) 오류가 발생한다.
     *     - 생성자 주입은 의존성이 있는 객체가 생성되지 않으면 객체 생성이 불가능하여 어플리케이션 실행 시점에 오류가 발생한다.
     *
     * - 객체의 불변성을 보장할 수 있다.
     *     - 필드에 final 키워드를 사용 할 수 있고 객체 생성 이후 의존성을 변경할 수 없어 안정성이 보장 된다.
     *
     * - 코드 가독성이 좋다.
     *     - 해당 객체가 어떤 의존성을 가지고 있는지 명확히 알 수 있다.
     *
     * - DI 컨테이너와의 결합도가 낮기 때문에 테스트 하기 좋다.
     *     - 스프링 컨테이너 없이 테스트를 할 수 있다.
     */
}
