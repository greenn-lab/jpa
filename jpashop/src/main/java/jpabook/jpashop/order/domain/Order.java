package jpabook.jpashop.order.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.AttributeConverter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import jpabook.jpashop.entity.auditor.AuditorEntity;
import jpabook.jpashop.user.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDERS")
@Setter
@Getter
public class Order extends AuditorEntity {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ID")
  private Long id;

  @OneToOne
  @JoinColumn(name = "MEMBER_ID")
  private Member member;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItem> orderItems = new ArrayList<>();

  @OneToOne
  @JoinColumn(name = "DELIVERY_ID")
  private Delivery delivery;

  private LocalDate orderDate;

  private OrderStatus status;

  public void addOrderItem(OrderItem orderItem) {
    if (!orderItems.contains(orderItem)) {
      orderItem.setOrder(this);
      orderItems.add(orderItem);
    }
  }


  @Getter
  public enum OrderStatus {
    ORDERED("OS001"),
    IN_CART("OS002"),
    RETURNED("OS003");

    private String code;

    OrderStatus(String code) {
      this.code = code;
    }

  }

  @Converter(autoApply = true)
  public static class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {

    @Override
    public String convertToDatabaseColumn(OrderStatus attribute) {
      return Optional.ofNullable(attribute).orElse(OrderStatus.ORDERED).getCode();
    }

    @Override
    public OrderStatus convertToEntityAttribute(String dbData) {
      return OrderStatus.valueOf(dbData);
    }
  }
}
