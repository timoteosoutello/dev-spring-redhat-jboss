package com.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.model.User;
import com.github.repository.UserRepository;
import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping("/v1/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/pageable")
	public Page<User> query(@SortDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@GetMapping("/querydsl")
	public Page<User> query(@QuerydslPredicate(root = User.class) Predicate predicate,
			@SortDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
		return userRepository.findAll(predicate, pageable);
	}
}
