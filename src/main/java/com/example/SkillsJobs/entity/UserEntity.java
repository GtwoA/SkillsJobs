package com.example.SkillsJobs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    @Size(min = 8, max = 50)
    @Column(name = "email", unique = true, updatable = true)
    private String email;

    @NotBlank
    @Size(min = 8, max = 50)
    @Column(name = "password", updatable = true)
    private String password;

    @Column(name = "user_name", unique = true, updatable = true)
    private String name;

    @Column(name = "salary", updatable = true)
    private Integer salary;


}
