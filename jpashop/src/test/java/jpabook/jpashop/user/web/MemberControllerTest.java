package jpabook.jpashop.user.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import jpabook.jpashop.user.domain.Address;
import jpabook.jpashop.user.domain.Member;
import jpabook.jpashop.user.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@WebMvcTest(MemberController.class)
public class MemberControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private MemberService service;

  @Test
  public void shouldSaveMember() throws Exception {
    // GIVEN
    Member member = new Member();
    member.setUsername("test");
    member.setPassword("test123!");
    member.setName("tester");
    member.setAddress(
        Address.builder().city("Incheon").street("Gulporo 105").zipcode("21328").build());

    given(service.signUp(any())).willReturn(member);

    // WHEN
    final ResultActions perform = mvc.perform(
        post("/user/sign-up")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(
                "{\"id\":null,\"username\":\"test\",\"password\":\"test123!\",\"name\":\"tester\",\"address\":{\"city\":\"Incheon\",\"street\":\"Gulporo 105\",\"zipcode\":\"21328\"}}")
    );

    // THEN
    perform
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.password").doesNotExist())
        .andDo(print());
  }

  @Test
  public void shouldOccurError_username_too_short() throws Exception {
    // GIVEN
    Member member = new Member();
    member.setUsername("t");

    // WHEN
    final ResultActions perform = mvc
        .perform(post("/user/sign-up").contentType(MediaType.APPLICATION_JSON_UTF8)
            .content("{\"username\":\"t\"}"));

    // THEN
    perform
        .andExpect(status().isBadRequest());
  }

}
