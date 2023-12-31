package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        
        //컴퍼 = 베이스 활성화
        
        //베이스페키지 전달하는ㄷ 또다른방식

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");


        BookService bookService = context.getBean("bookServiceField", BookService.class);


        List<Book> books = bookService.findAllBooks();

        for(Book book : books) {
            System.out.println("book = " + book);
        }

    }
}
