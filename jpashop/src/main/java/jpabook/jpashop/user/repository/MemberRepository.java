package jpabook.jpashop.user.repository;

import jpabook.jpashop.user.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

  Member findByUsername(String username);

  boolean existsByUsername(String username);

}
