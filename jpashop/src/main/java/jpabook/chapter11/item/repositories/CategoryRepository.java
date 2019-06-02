package jpabook.chapter11.item.repositories;

import jpabook.chapter11.item.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  Category findByName(String name);

  List<Category> findAllByName(String name);

  List<Category> findAllByParentName(String parentName);
}
