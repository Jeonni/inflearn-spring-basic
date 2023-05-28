package hello.core.discount;

import hello.core.member.Member;

//할인 정책 인터페이스
public interface DiscountPolicy {
    int discount(Member member, int price);
}
