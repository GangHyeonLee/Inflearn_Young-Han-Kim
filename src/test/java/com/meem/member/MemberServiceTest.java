package com.meem.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.meem.AppConfig;
import com.meem.memeber.Grade;
import com.meem.memeber.Member;
import com.meem.memeber.MemberService;

public class MemberServiceTest {
    
    //DIP, OCP 위반
    //MemberService memberService = new MemberServiceImpl();
    
    //수정코드
    MemberService memberService;
    
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
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
