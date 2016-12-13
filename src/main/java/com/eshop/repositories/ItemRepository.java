package com.eshop.repositories;

import com.eshop.model.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by akshaybansod on 12/12/16.
 */
public interface ItemRepository extends CrudRepository<Item, Long> {
}
