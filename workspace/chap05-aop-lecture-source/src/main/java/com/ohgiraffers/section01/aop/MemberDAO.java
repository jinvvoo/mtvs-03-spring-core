package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDAO {

    private final Map<Long, Member> memberMap;

    public MemberDAO() {
        this.memberMap = new HashMap<>();

        this.memberMap.put(1L, new Member(1L, "유관순"));
        this.memberMap.put(2L, new Member(2L, "홍길동"));
    }

    public List<Member> findAllMember() {
        return new ArrayList<>(memberMap.values());
    }

    public Member findMemberById(long id) {

        Member foundMember = memberMap.get(id);

        if (foundMember == null) {
            throw new IllegalArgumentException("해당하는 id의 회원이 없습니다");
        }
        return foundMember;
    }
}