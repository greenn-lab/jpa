package jpabook.jpashop.user.service;

import java.util.List;
import jpabook.jpashop.user.domain.Member;
import jpabook.jpashop.user.exception.AlreadyExistsUsernameException;
import jpabook.jpashop.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository repository;

  public Member signUp(Member member) {
    final String username = member.getUsername();

    if (existsUsername(username)) {
      throw new AlreadyExistsUsernameException(username);
    }

    return repository.save(member);
  }

  @Override
  public List<Member> getUsers(Member.Search search) {
    return repository.findAll();
  }

  private boolean existsUsername(String username) {
    return repository.existsByUsername(username);
  }
}
