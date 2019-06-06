package jpabook.jpashop.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  @Column(unique = true)
  @Size(min = 4, max = 16)
  private String username;

  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;

  @Size(min = 2, max = 64)
  private String name;

  @Embedded
  private Address address;

  @Setter
  @Getter
  public static class Search {

    private String type;
    private String keyword;
  }
}
