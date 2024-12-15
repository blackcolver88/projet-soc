package com.example.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "\"stats\"", schema = "public") 
@Data
public class stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "job")
    private String job;

    @Column(name = "marital")
    private String marital;

    @Column(name = "education")
    private String education;

    @Column(name = "\"default\"")
    private String defaultStatus;
     

    @Column(name = "balance")
    private Long balance;

    @Column(name = "housing")
    private String housing;

    @Column(name = "loan")
    private String loan;

    @Column(name = "contact")
    private String contact;

    @Column(name = "day")
    private Integer day;

    @Column(name = "month")
    private String month;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "campaign")
    private Integer campaign;

    @Column(name = "pdays")
    private Integer pdays;

    @Column(name = "previous")
    private Integer previous;

    @Column(name = "poutcome")
    private String poutcome;

    @Column(name = "subscribed")
    private String subscribed;

}
