package com.meem;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.meem.discount.DiscountPolicy;
import com.meem.discount.RateDiscountPolicy;
import com.meem.memeber.MemberRepository;
import com.meem.memeber.MemberService;
import com.meem.memeber.MemberServiceImpl;
import com.meem.memeber.MemoryMemberRepository;
import com.meem.order.OrderService;
import com.meem.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    
    @Bean
    public DiscountPolicy discountPolicy() {
       // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
    
    
    
    
    

}
