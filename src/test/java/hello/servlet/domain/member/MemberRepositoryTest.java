package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void getInstance() {
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);

        //when
        Member savedMember = memberRepository.save(member);//저장된 객체 생성

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        //저장한 객체 찾아오기
        assertThat(findMember).isEqualTo(savedMember);
        //찾아온 객체와 저장한 객체 비교
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {

        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> allMembers = memberRepository.findAll();

        //then

        assertThat(allMembers.size()).isEqualTo(2);
        assertThat(allMembers).contains(member1, member2);
    }

    @Test
    void clearStore() {

    }
}