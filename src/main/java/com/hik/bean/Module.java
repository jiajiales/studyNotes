package com.hik.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity(name="module") 
public class Module {
	@Id 
    @GeneratedValue  
    private int tid;
    @Column(name="tname",length=20)  
    private String tname;
    
    
}
