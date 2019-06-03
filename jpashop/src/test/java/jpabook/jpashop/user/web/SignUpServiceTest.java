package jpabook.jpashop.user.web;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import jpabook.jpashop.user.domain.Member;
import jpabook.jpashop.user.repository.MemberRepository;
import jpabook.jpashop.user.web.exception.AlreadyExistsUsernameException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SignUpServiceTest {

  @Autowired
  private SignUpService service;

  @MockBean
  private MemberRepository repository;

  @Test(expected = AlreadyExistsUsernameException.class)
  public void shouldDenySignUpMemberBecauseAlreadyExistsUsername() {
    // GIVEN
    given(repository.existsByUsername(anyString())).willReturn(true);

    // WHEN
    Member tester = new Member();
    tester.setUsername("tester");
    tester.setName("tester");

    service.signUp(tester);

    // THEN threw exception
  }

  @Test
  public void shouldSignUpMemberSuccess() {
    // GIVEN
    // WHEN
    Member tester = new Member();
    tester.setUsername("tester");
    tester.setName("tester");

    final Member member = service.signUp(tester);

    // THEN
    verify(repository, times(1)).save(tester);

  }
}
