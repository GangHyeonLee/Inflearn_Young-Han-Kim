package com.meem.order;

import com.meem.discount.DiscountPolicy;
import com.meem.discount.FixDiscountPolicy;
import com.meem.memeber.Member;
import com.meem.memeber.MemberRepository;
import com.meem.memeber.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
