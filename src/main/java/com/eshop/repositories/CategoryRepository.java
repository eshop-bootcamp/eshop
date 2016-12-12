package com.eshop.repositories;

import com.eshop.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sappana on 12/12/2016.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
