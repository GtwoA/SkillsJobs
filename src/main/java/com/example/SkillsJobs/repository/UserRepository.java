package com.example.SkillsJobs.repository;

import com.example.SkillsJobs.entity.SkillEntity;
import com.example.SkillsJobs.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
