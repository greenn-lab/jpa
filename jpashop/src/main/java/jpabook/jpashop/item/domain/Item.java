package jpabook.jpashop.item.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import jpabook.jpashop.entity.auditor.AuditorEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Setter
@Getter
public abstract class Item extends AuditorEntity {

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
