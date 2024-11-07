package org.example.ge.domain.expense.dto.response;

import java.util.List;

public record GetExpenseDataResponse(
        List<ExpenseData> expenseData
) {
}
