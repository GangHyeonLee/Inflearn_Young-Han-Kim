package com.meem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.meem.memeber.Grade;
import com.meem.memeber.Member;
import com.meem.memeber.MemberService;
import com.meem.memeber.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        
        // DIP, OCP 위반
        //MemberService memberService = new MemberServiceImpl();
        
        //수정코드
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService= appConfig.memberService();
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService= applicationContext.getBean("memberService", MemberService.class);
        
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());


    }

}
