package com.ohgiraffers.section01.autowired.common;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("bookDAO")  // 항상 클래스 쪽에
public class BookDAOImpl implements BookDAO {

    /* final 붙이는 기준 : 일단 다 붙이고, 써야 할 때(가변적일 때) 뺸다. */


    private final Map<Integer, Book> bookList;

    public BookDAOImpl(){
        this.bookList = new HashMap<>();

        bookList.put(1, new Book(1, 123456, "자바의정석", "남궁정", "도우출판", new java.util.Date()));
        bookList.put(2, new Book(2, 654321, "칭찬은 고래도 춤추게한다", "고래", "고래출판", new java.util.Date()));
    }

    @Override

    public List<Book> findAllbooks() {
        return new ArrayList<>(bookList.values());
    }

    @Override
    public Book findBookBySequence(int sequence) {
        return bookList.get(sequence);
    }
}
