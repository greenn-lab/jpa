package jpabook.jpashop.order.web;

import java.util.List;
import jpabook.jpashop.order.domain.Order;
import jpabook.jpashop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService service;

  @GetMapping
  public List<Order> orders() {
    return service.getOrders();
  }

  @PostMapping
  @PutMapping
  public void saveOrder(@RequestBody @Validated Order order) {
    service.save(order);
  }

}
