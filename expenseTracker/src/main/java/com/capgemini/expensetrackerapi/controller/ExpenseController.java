
package com.capgemini.expensetrackerapi.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.expensetrackerapi.entity.Expense;
import com.capgemini.expensetrackerapi.service.ExpenseService;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
    @GetMapping("/expenses")	
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseService.getAllExpenses(page);
	}
    
    // url using path variable
    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
    	return expenseService.getExpenseById(id);
    }
    
    //url using the query strings
    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam("id") Long id) {
    	 expenseService.deleteExpenseById(id);
    }
    
    @ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@Valid @RequestBody Expense expense) {
		return expenseService.saveExpenseDetails(expense);
	}
    
    
    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id) {
    	return expenseService.updateExpenseDetails(id, expense);
    	
    }
    
    @GetMapping("/expenses/category")
    public List<Expense> getExpenseByCategory(@RequestParam String category, Pageable page){
    	return expenseService.readByCategory(category, page);
    	
    }
    
    @GetMapping("/expenses/name")
    public List<Expense> getExpenseByName(@RequestParam String keyword, Pageable page){
    	return expenseService.findByNameContaining(keyword, page);
    }

}
