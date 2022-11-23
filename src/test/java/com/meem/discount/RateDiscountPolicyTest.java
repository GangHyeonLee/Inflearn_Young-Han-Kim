package com.meem.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.meem.memeber.Grade;
import com.meem.memeber.Member;
import com.meem.memeber.MemberService;
import com.meem.memeber.MemberServiceImpl;


public class RateDiscountPolicyTest {
    
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
    
    @Test
    @DisplayName("VIP는 10% 할인이된다.")
    void vip_o(){
        
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }
    
    @Test
    @DisplayName("VIP가 아니면 할인이 없다.")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);
        
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        
        //then
        Assertions.assertThat(discount).isEqualTo(0);
        
    }

}
