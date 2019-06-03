package jpabook.jpashop.order.domain;

import jpabook.jpashop.item.domain.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class OrderItem {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ITEM_ID")
  private Long id;

  @OneToOne
  @JoinColumn(name = "ITEM_ID")
  private Item item;

  @ManyToOne
  @JoinColumn(name = "ORDER_ID")
  private Order order;

  private Integer orderPrice;
  private Integer count;

}
