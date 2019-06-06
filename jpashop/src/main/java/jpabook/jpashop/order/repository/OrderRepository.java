package jpabook.jpashop.order.repository;

import jpabook.jpashop.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
