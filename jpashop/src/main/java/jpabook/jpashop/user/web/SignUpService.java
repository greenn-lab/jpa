package jpabook.jpashop.user.web;

import jpabook.jpashop.user.domain.Member;
import jpabook.jpashop.user.repository.MemberRepository;
import jpabook.jpashop.user.web.exception.AlreadyExistsUsernameException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SignUpService {

  private final MemberRepository repository;

  public Member signUp(Member member) {
    final String username = member.getUsername();

    if (existsUsername(username))
      throw new AlreadyExistsUsernameException(username);

    return repository.save(member);
  }

  private boolean existsUsername(String username) {
    return repository.existsByUsername(username);
  }
}
