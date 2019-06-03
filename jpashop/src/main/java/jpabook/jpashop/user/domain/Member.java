package jpabook.jpashop.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import lombok.ToString;

@Entity
@JsonIgnoreProperties({"password"})
@Setter
@Getter
@ToString
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  private String username;
  private String password;
  private String name;

  @Embedded
  private Address address;

}
