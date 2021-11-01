package hello.core.discount;

import hello.core.Member.Member;

public interface DiscountPolicy {
    /*
    * @return 할인 대상 금액
    * */
    int dicount(Member member, int price);

}