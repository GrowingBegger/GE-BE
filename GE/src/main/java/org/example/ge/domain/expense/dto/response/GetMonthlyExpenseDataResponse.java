package org.example.ge.domain.expense.dto.response;

import java.util.List;

public record GetMonthlyExpenseDataResponse (
        List<DailyExpenseDatum> dailyExpenseData
) {
}
