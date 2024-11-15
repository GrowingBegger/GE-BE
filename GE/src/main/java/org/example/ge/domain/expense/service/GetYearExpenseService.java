package org.example.ge.domain.expense.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.expense.dto.response.ExpenseData;
import org.example.ge.domain.expense.dto.response.GetExpenseDataResponse;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetYearExpenseService {
    private final CurrentUserProvider currentUserProvider;
    private final PostRepository postRepository;

    public GetExpenseDataResponse execute() {
        Long userId = currentUserProvider.getCurrentUserId();

        List<Object[]> result = postRepository.getSumOfExpensesOfCurrentYearByUserId(userId);
        List<ExpenseData> expenseData = result.stream()
                .map(row -> new ExpenseData(Integer.parseInt((String) row[0]), ((BigDecimal) row[1]).longValue()))
                .toList();

        return new GetExpenseDataResponse(calculate(expenseData));
    }

    private List<ExpenseData> calculate(List<ExpenseData> expenseData) {
        int idx = 0;
        List<ExpenseData> result = new ArrayList<>();
        int[] monthList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        for (ExpenseData datum:expenseData) {
            while (!(monthList[idx] == datum.month())) {
                result.add(new ExpenseData(monthList[idx++], 0L));
            }
            result.add(datum);
            idx++;
        }
        while (idx < 12) result.add(new ExpenseData(monthList[idx++], 0L));

        return result;
    }
}
