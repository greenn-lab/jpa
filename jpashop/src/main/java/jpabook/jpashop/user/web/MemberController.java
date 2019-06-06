package jpabook.jpashop.user.web;

import jpabook.jpashop.user.domain.Member;
import jpabook.jpashop.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/sign-up")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Member signUp(@RequestBody @Validated Member member) {
    return service.signUp(member);
  }
}
