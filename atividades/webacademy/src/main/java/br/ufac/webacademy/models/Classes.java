package br.ufac.webacademy.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Classes implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    private Long id;
    
    @ManyToOne(optional = false)
    private Class aClass;
    
    @Column
    private String email;
    
    @Column(nullable = false)
    private Date date;
    
    @Column(nullable = false)
    private Date startTime;
    
    @Column(nullable = false)
    private Date endTime;
}

