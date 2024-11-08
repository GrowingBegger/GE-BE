package org.example.ge.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Getter
@Setter
@Entity
@Builder
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(20)")
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String nickname;

    @Column(nullable = false, columnDefinition = "VARCHAR(225)")
    private String password;

    @Column(nullable = false)
    @ColumnDefault(value = "0")
    private Long target;

    @Column(nullable = false)
    @ColumnDefault(value = "'Default_img_url'") // todo: 기본 이미지 확정되면 여기에 링크 넣기
    private String profile;
}
