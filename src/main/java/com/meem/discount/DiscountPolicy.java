package com.meem.discount;

import com.meem.memeber.Member;

public interface DiscountPolicy {
    
    /* @return 할인 대상 금액 */
    
    int discount(Member member, int price);

}
