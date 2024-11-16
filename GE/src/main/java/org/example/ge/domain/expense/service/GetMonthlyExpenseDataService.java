package org.example.ge.domain.expense.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.expense.dto.response.DailyExpenseDatum;
import org.example.ge.domain.expense.dto.response.ExpenseDatumOfTitleAndPrice;
import org.example.ge.domain.expense.dto.response.GetMonthlyExpenseDataResponse;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetMonthlyExpenseDataService {
    private final CurrentUserProvider currentUserProvider;
    private final PostRepository postRepository;

    public GetMonthlyExpenseDataResponse execute() {
        Long userId = currentUserProvider.getCurrentUserId();
        List<Object[]> expenses = postRepository.getExpensesOfCurrentMonthByUserId(userId);

        List<DailyExpenseDatum> groupedExpenses = new ArrayList<>();
        for (int date = 1; date < YearMonth.now().lengthOfMonth() + 1; date++) {
            List<ExpenseDatumOfTitleAndPrice> dailyData = new ArrayList<>();
            for (Object[] expense: expenses) {
                if (Integer.parseInt((String) expense[0]) == date) {
                    dailyData.add(new ExpenseDatumOfTitleAndPrice((String) expense[1], ((BigDecimal) expense[2]).longValue()));
                }
            }
            if (!dailyData.isEmpty()) {
                groupedExpenses.add(new DailyExpenseDatum(date, dailyData));
            }
        }

        return new GetMonthlyExpenseDataResponse(groupedExpenses);
    }
}
