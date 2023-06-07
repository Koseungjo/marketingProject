package com.example.marketing.project.repository;

import com.example.marketing.project.entity.MarketingProject;
import jakarta.persistence.Id;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MarketingProjectRepository extends JpaRepository<MarketingProject,Long> {

    @Query("SELECT mp FROM MarketingProject mp " +
            "WHERE 1=1 " +
            "AND (:projectName = '' OR mp.projectName LIKE CONCAT('%', :projectName, '%')) " +
            "AND (:status = 'A' OR mp.status = :status)")
    List<MarketingProject> findAllByProjectNameAndStatus(Pageable pageable, String projectName, String status);


    Optional<MarketingProject> findByProjectId(Long id);

    Optional<MarketingProject> findByProjectIdAndStatus(Long id, String status);
}
