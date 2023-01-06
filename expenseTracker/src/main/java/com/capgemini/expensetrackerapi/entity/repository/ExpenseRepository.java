package com.capgemini.expensetrackerapi.entity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.expensetrackerapi.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	// select * from tb1_expenses WHERE category =?
	Page<Expense> findByCategory(String category, Pageable page);

//select * from tb1_expenses WHERE name LIKE "%KEYWORD%"
	Page<Expense> findByNameContaining(String keyword, Pageable page);
}
