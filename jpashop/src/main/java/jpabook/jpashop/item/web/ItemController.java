package jpabook.jpashop.item.web;

import java.util.List;
import jpabook.jpashop.item.domain.Item;
import jpabook.jpashop.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

  private final ItemService service;

  @GetMapping
  public List<Item> getItem() {
    return service.getItems();
  }

  @PostMapping
  @PutMapping
  public void saveItem(@RequestBody @Validated Item item) {
    service.save(item);
  }
}
