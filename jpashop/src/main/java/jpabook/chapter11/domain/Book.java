package jpabook.chapter11.domain;

import jpabook.chapter11.item.domains.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Setter
@Getter
public class Book extends Item {

  private String author;
  private String isbn;

}
