package hello.hellospring.repository;

import org.assertj.core.api.Assertions;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository=new MemoryMemberRepository();

    //테스트들은 각 서로 의존관계가 없어야 함
    //테스트는 정해진 순서가 없기 때문에 각 케이스마다 테스트를 거치면 초기화를 시켜줘야한다.
    //그래서 사용하는 함수가 아래 AfterEach 함수
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        //새로운 객체 만들기
        Member member=new Member();
        member.setName("spring");

        repository.save(member);

        //데이터베이스에서 꺼내기
        Member result=repository.findById(member.getId()).get();

        /*두개의 결과값이 같으면 테스트 통과*/
        //System.out.println("result= "+ (result==member));
        //이런식으로 계속 글자로 볼 수는 없으니 assert 방법으로
        //Assertions.assertEquals(member, result);//junit 클래스
        //같을 경우 아무 일도 일어나지 않고 다르면 런할 때 에러 발생
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result=repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
