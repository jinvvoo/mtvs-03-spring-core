package com.ohgiraffers.common;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
//@Data
public class Member {

    private int sequence;   //회원번호
    private String id;      //아이디
    private String pwd;     //비밀번호
    private String name;    //이름


}
