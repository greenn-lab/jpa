package jpabook.jpashop.entity.auditor;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public class AuditorEntity {

  @CreatedBy
  private String creator;

  @CreatedDate
  private LocalDateTime created;

  @LastModifiedBy
  private String updater;

  @LastModifiedDate
  private LocalDateTime updated;

}
