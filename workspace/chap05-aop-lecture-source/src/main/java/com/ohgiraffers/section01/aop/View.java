package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
public class View {

    private final MemberController memberController;

    @Autowired
    public View(MemberController memberController) {
        this.memberController = memberController;
    }

    public void findAllMembers() {

        List<MemberInfoResponseDTO> members = memberController.findAllMembers();
        printMembers(members);
    }
    public void findMemberById() {

        Scanner sc = new Scanner(System.in);
        System.out.println("조회하실 사용자 아이디를 입력해주세요 :");
        String id = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("id", id);

        MemberInfoResponseDTO member = memberController.findMemberById(parameter);
        printMember(member);

    }

    public void printMember(MemberInfoResponseDTO member) {
        System.out.println(member);
    }

    private void printMembers(List<MemberInfoResponseDTO> members) {
        members.forEach(this::printMember);
    }
}
