package jpabook.chapter11.user.repository;

import jpabook.chapter11.user.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
