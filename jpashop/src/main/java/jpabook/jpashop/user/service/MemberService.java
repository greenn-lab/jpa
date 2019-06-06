package jpabook.jpashop.user.service;

import java.util.List;
import jpabook.jpashop.user.domain.Member;

public interface MemberService {

  Member signUp(Member member);

  List<Member> getUsers(Member.Search search);
}
