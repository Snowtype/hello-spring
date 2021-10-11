package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService = new MemberService();

    @Test
    void 회원가입() { //과감하게 한글로 바꾸어도 됩니다. 실제 동작하지 않는 거라서... 실제포함되지않는 test코드라서
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        //when
        Member member2 = new Member();
        member2.setName("spring");

        //then
        memberService.join(member1);

    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}