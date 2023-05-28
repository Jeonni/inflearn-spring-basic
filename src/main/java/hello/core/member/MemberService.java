package hello.core.member;

//회원 서비스 인터페이스
public interface MemberService {
    void join(Member member); //회원가입
    Member findMember(Long memberId); //회원조회
}
