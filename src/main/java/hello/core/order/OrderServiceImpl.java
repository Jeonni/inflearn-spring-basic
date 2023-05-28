package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

//주문 서비스 구현체
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    /*
        주문 생성 요청이 오면 회원 정보를 조회하고 할인 정책을 적용한 다음, 주문 객체를 생성해서 반환한다.
        MemoryMemberRepository, FixDiscountPolicy 를 구현체로 생성한다.
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        //OrderService 입장에서 할인에 관한 내용은 DiscountPolicy 가 해결하게끔 1개의 책임을 전가 ==> SRP(단일 책임의 원칙)을 잘 지켰다.
        //그렇지 않으면 OrderService 에서 할인에 관한 변경이 들어올 경우 수정해야 하는 코드가 많아진다.
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}