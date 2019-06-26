package com.mercadito.repository;

import org.springframework.data.repository.CrudRepository;

import com.mercadito.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
