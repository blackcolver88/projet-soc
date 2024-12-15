package com.example.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.entity.stats;
import com.example.rest.repositories.StatisticsRepository;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public List<stats> getAllStatistics() {
        return statisticsRepository.findAll();
    }

    public Optional<stats> getStatisticsById(Long id) {
        return statisticsRepository.findById(id);
    }

    public stats createStatistics(stats statistics) {
        return statisticsRepository.save(statistics);
    }

    public stats updateStatistics(Long id, stats updatedStatistics) {
        return statisticsRepository.findById(id).map(existingStat -> {
            existingStat.setAge(updatedStatistics.getAge());
            existingStat.setJob(updatedStatistics.getJob());
            existingStat.setMarital(updatedStatistics.getMarital());
            existingStat.setEducation(updatedStatistics.getEducation());
            existingStat.setDefaultStatus(updatedStatistics.getDefaultStatus());
            existingStat.setBalance(updatedStatistics.getBalance());
            existingStat.setHousing(updatedStatistics.getHousing());
            existingStat.setLoan(updatedStatistics.getLoan());
            existingStat.setContact(updatedStatistics.getContact());
            existingStat.setDay(updatedStatistics.getDay());
            existingStat.setMonth(updatedStatistics.getMonth());
            existingStat.setDuration(updatedStatistics.getDuration());
            existingStat.setCampaign(updatedStatistics.getCampaign());
            existingStat.setPdays(updatedStatistics.getPdays());
            existingStat.setPrevious(updatedStatistics.getPrevious());
            existingStat.setPoutcome(updatedStatistics.getPoutcome());
            existingStat.setSubscribed(updatedStatistics.getSubscribed());
            return statisticsRepository.save(existingStat);
        }).orElseThrow(() -> new RuntimeException("Statistics with ID " + id + " not found"));
    }

    public void deleteStatistics(Long id) {
        if (statisticsRepository.existsById(id)) {
            statisticsRepository.deleteById(id);
        } else {
            throw new RuntimeException("Statistics with ID " + id + " does not exist");
        }
    }

    public List<stats> getStatisticsByJob(String job) {
        return statisticsRepository.findByJob(job);
    }

    public long countAllStatistics() {
        return statisticsRepository.count();
    }

    public boolean existsById(Long id) {
        return statisticsRepository.existsById(id);
    }
}
