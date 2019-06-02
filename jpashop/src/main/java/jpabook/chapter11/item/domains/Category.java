package jpabook.chapter11.item.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Category {

  @Id
  @GeneratedValue
  @Column(name = "CATEGORY_ID")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "PARENT_ID")
  private Category parent;

  @OneToMany(mappedBy = "parent")
  private List<Category> children = new ArrayList<>();

  private String name;

}