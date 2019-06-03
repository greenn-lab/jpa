package jpabook.chapter11.order.domain;

import jpabook.chapter11.user.domain.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Setter
@Getter
public class Delivery {

  @Id
  @GeneratedValue
  @Column(name = "DELIVERY_ID")
  private Long id;

  private DeliveryStatus status;

  @Embedded
  private Address address;

  public enum DeliveryStatus {
    READY("D0000"),
    DELIVERED("D0001"),
    COMPLETED("D0002"),
    RETURNED("D0003");

    private String code;

    DeliveryStatus(String code) {
      this.code = code;
    }
  }

  @Converter(autoApply = true)
  public static class DeliveryStatusConverter implements AttributeConverter<DeliveryStatus, String> {
    @Override
    public String convertToDatabaseColumn(DeliveryStatus attribute) {
      return Optional.ofNullable(attribute).orElse(DeliveryStatus.READY).code;
    }

    @Override
    public DeliveryStatus convertToEntityAttribute(String dbData) {
      return DeliveryStatus.valueOf(dbData);
    }
  }
}
