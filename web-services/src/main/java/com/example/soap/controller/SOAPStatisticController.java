package com.example.soap.controller;

import com.example.soap.entity.stats;
import com.example.rest.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

@Endpoint
public class SOAPStatisticController {

    private static final String NAMESPACE_URI = "http://example.com/soap";


    @Autowired
    private StatisticsService statisticService;

    @SoapAction("findStatisticById")
    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStatisticByIdRequest")
    public stats getStatisticById(@RequestPayload Long id) {
        return statisticService.getStatisticsById(id)
            .map(stat -> {
                stats soapStat = new stats();
                soapStat.setId(stat.getId());
                soapStat.setAge(stat.getAge());
                soapStat.setJob(stat.getJob());
                soapStat.setMarital(stat.getMarital());
                soapStat.setEducation(stat.getEducation());
                soapStat.setBalance(stat.getBalance());
                soapStat.setHousing(stat.getHousing());
                soapStat.setLoan(stat.getLoan());
                soapStat.setContact(stat.getContact());
                soapStat.setDay(stat.getDay());
                soapStat.setMonth(stat.getMonth());
                soapStat.setDuration(stat.getDuration());
                soapStat.setCampaign(stat.getCampaign());
                soapStat.setPdays(stat.getPdays());
                soapStat.setPrevious(stat.getPrevious());
                soapStat.setPoutcome(stat.getPoutcome());
                soapStat.setSubscribed(stat.getSubscribed());
                return soapStat;
            }).orElse(null);
    }
}
