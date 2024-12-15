package com.example.rest.repositories;

import org.springframework.stereotype.Repository;

import com.example.rest.entity.stats;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StatisticsRepository extends JpaRepository<stats, Long> {

    List<stats> findByJob(String job);

}
