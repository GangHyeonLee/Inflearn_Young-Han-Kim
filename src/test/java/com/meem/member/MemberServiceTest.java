package com.meem.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.meem.memeber.Grade;
import com.meem.memeber.Member;
import com.meem.memeber.MemberService;
import com.meem.memeber.MemberServiceImpl;

public class MemberServiceTest {
    
    MemberService memberService = new MemberServiceImpl();
    
    @Test
    void Join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
