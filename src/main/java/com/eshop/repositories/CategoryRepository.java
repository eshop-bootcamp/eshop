package com.eshop.repositories;

import com.eshop.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sappana on 12/12/2016.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
