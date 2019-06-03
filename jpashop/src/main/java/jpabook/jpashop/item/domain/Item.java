package jpabook.jpashop.item.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Setter
@Getter
public abstract class Item {

  @Id
  @GeneratedValue
  @Column(name = "ITEM_ID")
  private Long id;

  private String name;
  private Integer price;
  private Integer stockQuantity;

  @ManyToMany
  @JoinTable(
      name = "CATEGORY_ITEM",
      joinColumns = @JoinColumn(name = "ITEM_ID"),
      inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
  )
  private List<Category> categories = new ArrayList<>();

  public void addCategory(Category category) {
    if (!categories.contains(category)) {
      categories.add(category);
    }
  }
}
