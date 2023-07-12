package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,MemberRepository {
    //인터페이스가 인터페이스를 상속받을 때는 extends를 사용
    //인터페이스는 다중 상속이 가능

    //JPQL select m from Member m where m.name=?//자동으로 작성
    @Override
    Optional<Member> findByName(String name);
}
