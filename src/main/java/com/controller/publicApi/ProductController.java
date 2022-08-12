package com.controller.publicApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;
import com.repository.ProductRepository;

@RestController
@RequestMapping("/publicApi")
public class ProductController {
 
	@Autowired
	ProductRepository productRepo;
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody ProductBean product)
	{
		productRepo.save(product);
		return ResponseEntity.ok(product);
		
	}
	
	
	
}
