package com.meem.discount;

import com.meem.memeber.Grade;
import com.meem.memeber.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인
    
    @Override
    public int discount(Member member, int price) {
        // TODO Auto-generated method stub
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0 ;
        }
    }

}
