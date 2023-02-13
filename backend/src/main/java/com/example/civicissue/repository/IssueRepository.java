package com.example.civicissue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.civicissue.model.CivicIssue;
import com.example.civicissue.model.User;


@Repository
public interface IssueRepository extends JpaRepository<CivicIssue, Long> {
  
  Optional<CivicIssue> findByUser(User user);

  
}