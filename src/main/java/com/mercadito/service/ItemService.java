package com.mercadito.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadito.entity.Item;
import com.mercadito.exception.ResourceNotFoundException;
import com.mercadito.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public Item save(final Item item) {
		return this.itemRepository.save(item);
	}
	
	public void delete(final long itemId) {
		Item item = this.itemRepository.findById(itemId).orElse(null);
		this.itemRepository.delete(item);
	}
	
	public List<Item> getAll() {
		List<Item> itemList = new ArrayList<Item>();
		this.itemRepository.findAll().forEach(itemList :: add);
		return itemList;
	}
	
	public Item getById(final long itemId) {
		return this.itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));
	}
}
