package hello.core.member;

//회원 저장소 인터페이스
public interface MemberRepository {
    void save(Member member); //회원정보저장
    Member findById(Long memberId); //회원정보확인
}
