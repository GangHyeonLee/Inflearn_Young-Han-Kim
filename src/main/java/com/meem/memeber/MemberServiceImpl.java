package com.meem.memeber;

public class MemberServiceImpl implements MemberService {

    //DIP, OCP 위반
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    
    //수정코드
    private final MemberRepository memberRepository;
    
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        // TODO Auto-generated method stub
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        // TODO Auto-generated method stub
        return memberRepository.findById(memberId);
    }

}
