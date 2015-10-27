package com.springapp.mvc;

import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Wajih Sid on 10/27/2015.
 */

@Entity
@Table(name = "emp")


public class EmpDTO
{
    private Integer ID;
    private String NAME;
    private String EMAIL;

    @Id
    @Column(name = "ID")
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Column(name = "NAME")
    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Column(name = "EMAIL")
    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                '}';
    }

}
