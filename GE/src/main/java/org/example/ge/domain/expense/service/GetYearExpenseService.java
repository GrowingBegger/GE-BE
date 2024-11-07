package org.example.ge.domain.expense.service;

import lombok.RequiredArgsConstructor;
import org.example.ge.domain.expense.dto.response.ExpenseData;
import org.example.ge.domain.expense.dto.response.GetExpenseDataResponse;
import org.example.ge.domain.post.repository.PostRepository;
import org.example.ge.instrastructure.common.user.CurrentUserProvider;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetYearExpenseService {
    private final CurrentUserProvider currentUserProvider;
    private final PostRepository postRepository;

    public GetExpenseDataResponse execute() {
        Long userId = currentUserProvider.getCurrentUserId();

        List<Object[]> result = postRepository.getYearSum(Integer.toString(LocalDateTime.now().getYear()), userId);
        List<ExpenseData> expenseData = result.stream()
                .map(row -> new ExpenseData((String) row[0], ((BigDecimal) row[1]).longValue()))
                .toList();

        return new GetExpenseDataResponse(calculate(expenseData));
    }

    private List<ExpenseData> calculate(List<ExpenseData> expenseData) {
        int idx = 0;
        List<ExpenseData> result = new ArrayList<>();
        String[] monthList = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

        for (ExpenseData datum:expenseData) {
            while (!monthList[idx].equals(datum.month())) {
                result.add(new ExpenseData(monthList[idx++], 0L));
            }
            result.add(datum);
            idx++;
        }
        while (idx < 12) result.add(new ExpenseData(monthList[idx++], 0L));

        return result;
    }
}
