package org.example.ge.domain.expense.controller;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.expense.dto.response.ExpenseData;
import org.example.ge.domain.expense.dto.response.GetExpenseDataResponse;
import org.example.ge.domain.expense.dto.response.GetMonthlyExpenseDataResponse;
import org.example.ge.domain.expense.service.GetMonthlyExpenseDataService;
import org.example.ge.domain.expense.service.GetYearExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {
    private final GetYearExpenseService getYearExpenseService;
    private final GetMonthlyExpenseDataService monthlyExpenseDataService;

    @GetMapping("/year")
    @ResponseStatus(HttpStatus.OK)
    public GetExpenseDataResponse getExpense() {
        return getYearExpenseService.execute();
    }

    @GetMapping("/month")
    @ResponseStatus(HttpStatus.OK)
    public GetMonthlyExpenseDataResponse getMonthlyExpense() {
        return monthlyExpenseDataService.execute();
    }
}
