package hello.core.member;

import java.util.HashMap;
import java.util.Map;

//메모리 회원 저장소 구현체
public class MemoryMemberRepository implements MemberRepository{

    // HashMap 동시성 이슈 발생 가능 --> ConcurrentHashMap 사용 권장
    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) { //회원정보저장
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) { //회원정보확인
        return store.get(memberId);
    }
}
