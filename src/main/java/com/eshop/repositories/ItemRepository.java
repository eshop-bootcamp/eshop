package com.eshop.repositories;

import com.eshop.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    //List<Item> findByCategory(Category category);
}
