package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    // 중복을 제거하고, 역할에 따른 구현이 보이도록 리팩토링(1)
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // 중복을 제거하고, 역할에 따른 구현이 보이도록 리팩토링(2)
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy(); // 할인 정책에 대한 객체를 변경 (구성 영역인 AppConfig 코드만 변경 - 사용 영역은 손대지 않아도 됨)
    }
}
