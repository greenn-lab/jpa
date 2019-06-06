package jpabook.jpashop.order.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import jpabook.jpashop.entity.auditor.AuditorEntity;
import jpabook.jpashop.item.domain.Item;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class OrderItem extends AuditorEntity {

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
