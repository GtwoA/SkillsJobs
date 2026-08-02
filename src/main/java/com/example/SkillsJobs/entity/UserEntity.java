package com.example.SkillsJobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.*;

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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_skill",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<SkillEntity> skillList = new HashSet<>();

    @Column(name = "balance")
    private Integer balance;

    public Set<SkillEntity> getSkills() {
        return Collections.unmodifiableSet(skillList);
    }

    public void addSkill(SkillEntity skill) {
        this.skillList.add(skill);
        skill.getUserEntity().add(this);
    }
}
