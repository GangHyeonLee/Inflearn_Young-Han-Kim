package com.meem.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.meem.AppConfig;
import com.meem.memeber.Grade;
import com.meem.memeber.Member;
import com.meem.memeber.MemberService;
import com.meem.memeber.MemberServiceImpl;

public class OrderServiceTest {
    
    //DIP, OCP 위반
    //MemberService memberService = new MemberServiceImpl();
    //OrderService orderService = new OrderServiceImpl();
    
    //수정코드
    MemberService memberService;
    OrderService orderService;
    
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    
    @Test
    void createOrder() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        
        
        //when
        memberService.join(member);
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);
        
        //then
        
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
