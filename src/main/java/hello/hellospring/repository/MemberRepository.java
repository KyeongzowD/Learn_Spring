package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);//회원이 저장소에 저장
    Optional<Member> findById(Long id);//회원 아이디 조회
    Optional<Member> findByName(String name);//회원 이름 조회
    List<Member> findAll();//저장된 모든 회원 리스트를 반환
}
