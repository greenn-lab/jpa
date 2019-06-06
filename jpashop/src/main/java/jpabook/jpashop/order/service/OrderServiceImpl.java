package jpabook.jpashop.order.service;

import java.util.List;
import jpabook.jpashop.order.domain.Order;
import jpabook.jpashop.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository repository;

  @Override
  public Order save(Order order) {
    return repository.save(order);
  }

  @Override
  public List<Order> getOrders() {
    return repository.findAll();
  }
}
