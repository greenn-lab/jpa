package jpabook.jpashop.order.service;

import java.util.List;
import jpabook.jpashop.order.domain.Order;

public interface OrderService {

  Order save(Order order);

  List<Order> getOrders();

}
