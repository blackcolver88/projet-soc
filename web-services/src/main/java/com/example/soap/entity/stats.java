package com.example.soap.entity;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement(name = "stats")
@Data  
public class stats {

    private Long id;
    private Integer age;
    private String job;
    private String marital;
    private String education;
    private String defaultStatus;
    private Long balance;
    private String housing;
    private String loan;
    private String contact;
    private Integer day;
    private String month;
    private Integer duration;
    private Integer campaign;
    private Integer pdays;
    private Integer previous;
    private String poutcome;
    private String subscribed;

}
