package com.meem.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.meem.AppConfig;
import com.meem.memeber.MemberService;
import com.meem.memeber.MemberServiceImpl;

class ApplicationContextBasicFindTest {
    
  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        
    }
    
    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        
    }
    
    @Test
    @DisplayName("구체 타입으로 조회") //구체타입으로 적는건 좋지않다 이유:  해당코드는 구현에 의존함, 구현에의존하면 안되고 역할에 의존해야하기때문에
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        
    }
    
    @Test
    @DisplayName("빈 이름으로 조회 안되는경우") //실패상황도 만들어줘야함. 없는 이름으로 돌림
    void findBeanByNameX() {
       // MemberService xxxx =  ac.getBean("xxxx", MemberService.class); // 이렇게하면 터지니 아래처럼 익셉션처리
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }

}
