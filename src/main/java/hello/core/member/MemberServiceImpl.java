package hello.core.member;

//구현체가 하나만 있을 경우 인터페이스명 다음에 Impl 붙이는 관례가 있음
//회원 서비스 구현체
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) { //회원가입
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) { //회원조회
        return memberRepository.findById(memberId);
    }
}