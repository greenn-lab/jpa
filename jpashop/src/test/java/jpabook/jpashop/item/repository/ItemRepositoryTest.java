package jpabook.jpashop.item.repository;

import static org.assertj.core.api.Assertions.assertThat;

import jpabook.jpashop.item.domain.Album;
import jpabook.jpashop.item.domain.Category;
import jpabook.jpashop.item.domain.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

  @Autowired
  private ItemRepository repo;

  @Autowired
  private CategoryRepository categoryRepository;
  private Category album;

  @Before
  public void composeCategoriesForItem() {
    album = new Category();
    album.setName("ALBUM");

    Category sound = new Category();
    sound.setName("SOUND");
    sound.addChild(album);

    categoryRepository.save(sound);
  }

  @Test
  public void shouldCreateItem() {
    // GIVEN
    Album musicAlbum = new Album();
    musicAlbum.setName("BOY WITH LUV");
    musicAlbum.addCategory(album);
    musicAlbum.setArtist("BTS");
    musicAlbum.setEtc("BTS sixth EP");
    repo.save(musicAlbum);

    // WHEN
    Item boyWithLuv = repo.getOne(musicAlbum.getId());

    // THEN
    assertThat(boyWithLuv).isInstanceOf(Album.class);
  }

}
