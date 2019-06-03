package jpabook.jpashop.item.repository;

import jpabook.jpashop.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
