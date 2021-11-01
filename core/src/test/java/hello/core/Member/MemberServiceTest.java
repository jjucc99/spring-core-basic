package hello.core.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given => 어떤 객체를 줄 것인지
        Member test = new Member(1l, "Test", Grade.VIP);

        //when => 어떤 상황에 작동하는 지
        memberService.join(test);
        Member findMember = memberService.findMember(1l);

        //then => 어떤 결과물을 원하는 지
        Assertions.assertThat(test).isEqualTo(findMember);
    }

}
