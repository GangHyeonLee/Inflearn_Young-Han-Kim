package com.meem.discount;

import com.meem.memeber.Grade;
import com.meem.memeber.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    
    private int discountRateAmount = 1;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return price * discountRateAmount / 10;
        } else {
            return 0;
        }
    }
    
    

}
