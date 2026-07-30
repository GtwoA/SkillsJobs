package com.example.SkillsJobs.entity;

import com.example.SkillsJobs.enums.Position;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(name = "email", unique = true, updatable = true)
    private String email;

    @Column(name = "password", updatable = true)
    private String password;

    @Column(name = "user_name", unique = true, updatable = true)
    private String name;

    @Column(name = "salary", updatable = true)
    private Integer salary;

    @Column(name = "position")
    private String position;
}
