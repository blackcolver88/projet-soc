package com.example.rest.controllers;

import com.example.rest.entity.stats;
import com.example.rest.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class GraphQLStatisticController {

    @Autowired
    private StatisticsService statisticService;

    
    @QueryMapping
    public List<stats> getAllStatistics() {
        return statisticService.getAllStatistics();
    }

    @QueryMapping
    public stats getStatisticById(@Argument Long id) {
        return statisticService.getStatisticsById(id).orElse(null);
    }

    @MutationMapping
    public stats createStatistic(@Argument StatisticInput input) {
        stats statistic = new stats();
        statistic.setAge(input.getAge());
        statistic.setJob(input.getJob());
        statistic.setMarital(input.getMarital());
        statistic.setEducation(input.getEducation());
        statistic.setDefaultStatus(input.getDefaultStatus());
        statistic.setBalance((long) input.getBalance());
        statistic.setHousing(input.getHousing());
        statistic.setLoan(input.getLoan());
        statistic.setContact(input.getContact());
        statistic.setDay(input.getDay());
        statistic.setMonth(input.getMonth());
        statistic.setDuration(input.getDuration());
        statistic.setCampaign(input.getCampaign());
        statistic.setPdays(input.getPdays());
        statistic.setPrevious(input.getPrevious());
        statistic.setPoutcome(input.getPoutcome());
        statistic.setSubscribed(input.getSubscribed());

        return statisticService.createStatistics(statistic);
    }

    @MutationMapping
    public Boolean deleteStatistic(@Argument Long id) {
        statisticService.deleteStatistics(id);
        return true;
    }
}
