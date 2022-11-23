package com.meem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.meem.memeber.Grade;
import com.meem.memeber.Member;
import com.meem.memeber.MemberService;
import com.meem.memeber.MemberServiceImpl;
import com.meem.order.Order;
import com.meem.order.OrderService;
import com.meem.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        
        //DIP , OCP 위반
        //MemberService memberService = new MemberServiceImpl();
        
        //수정코드
        //AppConfig appConfig = new AppConfig();
       // MemberService memberService= appConfig.memberService();
        
        //DIP , OCP 위반
        //OrderService orderService = new OrderServiceImpl();
        
        //수정코드
        //OrderService orderService = appConfig.orderService();
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        
        Member findMember = memberService.findMember(1L);
        
        System.out.println("Grade=" + findMember.getGrade());
        

        
        Order order = orderService.createOrder(findMember.getId(), "itemA", 20000);
        
        
        System.out.println("order=" + order);
        
        
    }
}   
