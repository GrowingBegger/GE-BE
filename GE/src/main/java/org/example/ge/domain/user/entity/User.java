package org.example.ge.domain.user.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @ColumnDefault(value = "1")
    private int rank;

    @Column(nullable = false)
    @ColumnDefault(value = "0")
    private int exp;

    @Column(nullable = false)
    @ColumnDefault(value = "0")
    private Long target;
}
