package jpabook.jpashop.item.service;

import java.util.List;
import jpabook.jpashop.item.domain.Item;
import jpabook.jpashop.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

  private final ItemRepository repository;


  @Override
  public Item save(Item item) {
    return repository.save(item);
  }

  @Override
  public List<Item> getItems() {
    return repository.findAll();
  }

}
