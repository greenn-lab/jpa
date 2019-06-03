package jpabook.jpashop.user.web;

import javax.validation.Valid;
import jpabook.jpashop.user.domain.Member;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {

  @PostMapping
  public Member signup(@Valid Member member) {
    return null;
  }
}
