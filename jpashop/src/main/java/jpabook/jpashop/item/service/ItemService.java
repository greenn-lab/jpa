package jpabook.jpashop.item.service;

import java.util.List;
import jpabook.jpashop.item.domain.Item;

public interface ItemService {

  Item save(Item item);

  List<Item> getItems();

}
