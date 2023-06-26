package com.ohgiraffers.section01.autowired.subsection02.constructor;

//import com.ohgiraffers.section01.autowired.subsection01.field.BookService;

import com.ohgiraffers.section01.autowired.common.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Consumer;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("bookServiceConstructor", BookService.class);

        bookService.findAllBooks().forEach(System.out::println);

        /*
        bookService.findAllBooks().stream().forEach(book -> System.out.println(book)); // 람다.

         */

        /* 아래의 문구와 위에 람다형식은 동일
        bookService.findAllBooks().stream().forEach(new Consumer<Book>() {
            @Override
            public void accept(Book book) {
                System.out.println("book = " + book); // 이건 익명클래스

            }
        });
         */

        System.out.println(bookService.searchBookBySequence(1));

    }
}
