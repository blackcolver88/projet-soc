package com.example.rest.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.stats;
import com.example.rest.services.StatisticsService;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public List<stats> getAllStatistics() {
        return statisticsService.getAllStatistics();
    }
     @GetMapping("/{id}")
    public ResponseEntity<stats> getStatisticsById(@PathVariable Long id) {
        return statisticsService.getStatisticsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public stats createStatistics(@RequestBody stats statistics) {
        return statisticsService.createStatistics(statistics);
    }

    @PutMapping("/{id}")
    public ResponseEntity<stats> updateStatistics(@PathVariable Long id, @RequestBody stats statistics) {
        return ResponseEntity.ok(statisticsService.updateStatistics(id, statistics));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatistics(@PathVariable Long id) {
        statisticsService.deleteStatistics(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/job/{job}")
    public List<stats> getStatisticsByJob(@PathVariable String job) {
        return statisticsService.getStatisticsByJob(job);
    }

    @GetMapping("/count")
    public long countAllStatistics() {
        return statisticsService.countAllStatistics();
    }
}