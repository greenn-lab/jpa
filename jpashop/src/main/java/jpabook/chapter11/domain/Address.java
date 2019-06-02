package jpabook.chapter11.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
public class Address {

  private String city;
  private String street;
  private String zipcode;

}
