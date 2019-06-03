package jpabook.jpashop.user.repository;

import static org.assertj.core.api.Assertions.assertThat;

import jpabook.jpashop.user.domain.Address;
import jpabook.jpashop.user.domain.Member;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {

  @Autowired
  private MemberRepository repo;

  @Before
  public void onload() {
    Address home = new Address();
    home.setCity("Incheon");
    home.setStreet("Gulporo");
    home.setZipcode("21328");

    Member member = new Member();
    member.setId(1L);
    member.setUsername("tester");
    member.setName("tester");
    member.setAddress(home);

    repo.save(member);
  }

  @Test
  public void shouldFindMemberByUsername() {
    // GIVEN
    // WHEN
    Member tester = repo.findByUsername("tester");

    // THEN
    assertThat(tester).isNotNull();
  }

  @Test
  public void shouldRecognizeAlreadyExistsMemberByUsername() {
    // GIVEN
    // WHEN
    boolean exists = repo.existsByUsername("tester");
    boolean notExists = repo.existsByUsername("xxx");

    // THEN
    assertThat(exists).isTrue();
    assertThat(notExists).isFalse();
  }
}
