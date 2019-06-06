package jpabook.jpashop.order.domain;

import java.util.Optional;
import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Converter;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import jpabook.jpashop.entity.auditor.AuditorEntity;
import jpabook.jpashop.user.domain.Address;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Delivery extends AuditorEntity {

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
  public static class DeliveryStatusConverter implements
      AttributeConverter<DeliveryStatus, String> {

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
