package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//순수 자바 코드로 테스트 실행
//애플리케이션 로직으로 이렇게 테스트 하는 것은 좋은 방법이 아니다. JUnit 테스트를 사용하자.
public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
        // 기존의 코드와 다르게 MemerServiceImpl 을 직접 new 해서 생성하지 않음
        // AppConfig를 통해 memberService를 받는다.
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();


        // AppConfig에 @Bean 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // ctrl+alt+v
        Member member = new Member(1L, "member1", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new findMember = " + member.getName());
        System.out.println("find Member= " + findMember.getName());
    }
}
