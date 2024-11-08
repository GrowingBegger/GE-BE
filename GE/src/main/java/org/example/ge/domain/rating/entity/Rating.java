package org.example.ge.domain.rating.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Long userId;

    @Min(value = 0)
    @Max(value = 7)
    @Column(name = "rating", nullable = false, updatable = false)
    private Integer rating;

    private Double totalExp;

    public Rating(Long userId, Double totalExp) {
        this.userId = userId;
        setTotalExp(totalExp);
    }

    public void setTotalExp(Double totalExp) {
        this.totalExp = totalExp;
        updateRatingBasedOnTotalExp();
    }

    private void updateRatingBasedOnTotalExp() {
        if (totalExp < 1000) {
            this.rating = 0;
        } else if (totalExp < 5000) {
            this.rating = 1;
        } else if (totalExp < 10000) {
            this.rating = 2;
        } else if (totalExp < 20000) {
            this.rating = 3;
        } else if (totalExp < 50000) {
            this.rating = 4;
        } else if (totalExp < 100000) {
            this.rating = 5;
        } else if (totalExp < 200000) {
            this.rating = 6;
        } else {
            this.rating = 7;
        }
    }
}
