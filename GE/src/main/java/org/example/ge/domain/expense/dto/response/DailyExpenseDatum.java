package org.example.ge.domain.expense.dto.response;

import java.util.List;

public record DailyExpenseDatum(
        int date,

        List<ExpenseDatumOfTitleAndPrice> expenses
) {
}
