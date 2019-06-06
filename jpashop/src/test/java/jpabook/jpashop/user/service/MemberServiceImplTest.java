package jpabook.jpashop.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import jpabook.jpashop.user.domain.Member;
import jpabook.jpashop.user.exception.AlreadyExistsUsernameException;
import jpabook.jpashop.user.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceImplTest {

  @Autowired
  private MemberServiceImpl service;

  @MockBean
  private MemberRepository repository;

  @Test(expected = AlreadyExistsUsernameException.class)
  public void _01_이미_등록된_username_은_AlreadyExistsUsernameException() {
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
  public void _02_가입_성공() {
    // GIVEN
    // WHEN
    Member tester = new Member();
    tester.setUsername("tester");
    tester.setName("tester");

    final Member member = service.signUp(tester);

    // THEN
    verify(repository, times(1)).save(tester);
  }

  @Test
  public void _03_회원목록_불러오기() {
    // GIVEN
    Member member = new Member();
    member.setUsername("test");

    final List<Member> members = Arrays.asList(member);
    given(repository.findAll()).willReturn(members);

    // WHEN
    final List<Member> list = service.getUsers(null);

    // THEN
    assertThat(list).isNotNull();
    assertThat(list).hasSize(1);
  }
}
