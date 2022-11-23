package com.meem.memeber;

public interface MemberRepository {
    
    void save(Member member);
    
    Member findById(Long memberId);

}
