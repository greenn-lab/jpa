package jpabook.jpashop.user.repository;

import jpabook.jpashop.user.domain.Address;
import jpabook.jpashop.user.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {

  @Autowired
  private MemberRepository repo;

  @Test
  public void shouldCreateMemberWithAddress() {
    // GIVEN
    Address home = new Address();
    home.setCity("Incheon");
    home.setStreet("Gulporo");
    home.setZipcode("21328");

    Member member = new Member();
    member.setName("tester");
    member.setAddress(home);

    // WHEN
    repo.save(member);

    // THEN
    Optional<Member> tester = repo.findById(member.getId());
    assertThat(tester.isPresent()).isTrue();
    assertThat(tester.orElseThrow(NullPointerException::new).getAddress().getCity()).isEqualTo("Incheon");
  }
}
