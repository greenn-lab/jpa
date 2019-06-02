package jpabook.chapter11.item.repositories;

import jpabook.chapter11.item.domains.Category;
import jpabook.chapter11.item.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
@FixMethodOrder
public class CategoryTest {

  @Autowired
  private CategoryRepository repo;

  @Test
  public void _01_shouldCreate() {
    Category toy = createCategory("장난감");

    Category car = createCategory("자동차", toy);
    Category robocaPoly = createCategory("로보카폴리", car);
    Category poly = createCategory("폴리", robocaPoly);
    Category hely = createCategory("헬리", robocaPoly);
    Category ember = createCategory("엠버", robocaPoly);
    Category roy = createCategory("로이", robocaPoly);

    Category littleBusTayo = createCategory("꼬마버스타요", car);
    Category tayo = createCategory("타요", littleBusTayo);
    Category gayo = createCategory("가요", littleBusTayo);

    Category doll = createCategory("인형", toy);
    Category animationCharacter = createCategory("애니메이션 인형", doll);
    Category pororoFriends = createCategory("뽀로로와 친구들", animationCharacter);
    Category pororo = createCategory("뽀로로", pororoFriends);
    Category crong = createCategory("크롱", pororoFriends);
    Category eddy = createCategory("에디", pororoFriends);
    Category ruppy = createCategory("루피", pororoFriends);
    Category pobby = createCategory("포비", pororoFriends);

    Category movieCharacter = createCategory("영화 인형", doll);
    Category insideOut = createCategory("inside-out", movieCharacter);
    Category joy = createCategory("joy", insideOut);
    Category sadness = createCategory("sadness", insideOut);
    Category angry = createCategory("angry", insideOut);
  }

  @Test
  public void _02_shouldCategorize() {
    List<Category> eddy = repo.findAllByParentName("자동차");
  }

  private Category createCategory(String name, Category... parent) {
    Category c = new Category();
    c.setName(name);

    if (!ObjectUtils.isEmpty(parent)) {
      c.setParent(parent[0]);
    }

    return repo.save(c);
  }
}
