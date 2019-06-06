package jpabook.jpashop.order.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import jpabook.jpashop.order.domain.Order;
import jpabook.jpashop.order.service.OrderService;
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
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private OrderService service;

  @Test
  public void _01_orders_주문_목록을_가져와요() throws Exception {
    // given
    given(service.getOrders()).willReturn(Arrays.asList(new Order()));

    // when
    final ResultActions perform = mvc
        .perform(get("/order").contentType(MediaType.APPLICATION_JSON_UTF8));

    // then
    perform
        .andExpect(status().isOk());
  }

}
