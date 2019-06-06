package jpabook.jpashop.item.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import jpabook.jpashop.entity.auditor.AuditorEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Category extends AuditorEntity {

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

  public void addChild(Category category) {
    if (!children.contains(category)) {
      category.setParent(this);
      category.getChildren().add(category);
    }
  }
}
