package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        OrderService orderService = new AppConfig().orderService();
//        MemberService memberService = new AppConfig().memberService();

        ApplicationContext container = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        OrderService orderService = container.getBean(OrderService.class);
        MemberService memberService = container.getBean(MemberService.class);

        Long memberId = 1l;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1l, "itemA", 200000);
        System.out.println("order = " + order);

    }
}
