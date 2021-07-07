package com.restaurant_naver.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant_naver.wishlist.dto.WishListDto;
import com.restaurant_naver.wishlist.repository.WishListRepository;
import com.restaurant_naver.wishlist.service.WishListService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController {

	private final WishListService wishListService;
	
	
	@GetMapping("/search")
	public WishListDto search(@RequestParam String query) {
		
		return wishListService.search(query);
		
	}
	
	@PostMapping("")
	public WishListDto add(@RequestBody WishListDto wishListDto) {
		
		log.info("{}", wishListDto);
		
		return wishListService.add(wishListDto);
		
	}
	
	@GetMapping("/all")
	public List<WishListDto> findAll(){
		
		return wishListService.findAll();
		
	}
	
	@DeleteMapping("/{index}")
	public void delete(@PathVariable int index) {
		
		wishListService.delete(index);
		
	}
	
	@PostMapping("/{index}")
	public void addVisit(@PathVariable int index) {
		
		wishListService.addVisit(index);
		
	}
}
