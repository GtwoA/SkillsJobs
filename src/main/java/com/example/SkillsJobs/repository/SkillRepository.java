package com.example.SkillsJobs.repository;

import com.example.SkillsJobs.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long> {
    Optional<SkillEntity> findBySkill(String skill);

    @Query(nativeQuery = true, value = "select * from skill where skill like CONCAT('%', :substring, '%')")
    Set<SkillEntity> findSkillBySubstring(@Param("substring") String substring);
}
