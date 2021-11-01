package hello.core.order;

import hello.core.Member.Member;
import hello.core.Member.MemberRepository;
import hello.core.Member.MemoryMemberRepository;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixdiscountPolicy;

public class OrderServiceImpl implements OrderService{
    private  final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixdiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int dicountPrice = discountPolicy.dicount(member, itemPrice);

        return  new Order(memberId, itemName, itemPrice, dicountPrice);

    }
}
