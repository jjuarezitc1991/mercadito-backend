package com.mercadito.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadito.entity.Item;
import com.mercadito.service.ItemService;

@RestController
@RequestMapping("/api/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/")
	public ResponseEntity<List<Item>> getAll() {
		return new ResponseEntity<>(itemService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Item> create(@Valid @RequestBody Item item, BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(itemService.save(item), HttpStatus.CREATED);
	}
}
