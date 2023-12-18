package com.nighthawk.spring_portfolio.mvc.doctor;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Convert;
import static jakarta.persistence.FetchType.EAGER;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.format.annotation.DateTimeFormat;

import com.nighthawk.spring_portfolio.mvc.person.PersonRole;
import com.vladmihalcea.hibernate.type.json.JsonType;

import groovyjarjarpicocli.CommandLine.Unmatched;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Convert(attributeName ="person", converter = JsonType.class)
public class Doctor {
    @Id // Jakarta provided identifier; others include email, etc.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // email, password, roles are key attributes to login and authentication
    @NotEmpty
    @Size(min=2, max=30, message="Name between 2 and 30 Characters") // gives the size required
    private String name;

    @NotEmpty // Ensures query is not empty
    @Size(min=3, max=30, message="Username between 2 and 30 Characters") // Gives a minimum and maxiumum
    private String uname;

    @NotEmpty
    private String password;


    @ManyToMany  // Allows connection between classes -- similarly to connections within flask
    private Collection<DoctorRoles> roles = new ArrayList<>();

    

    public Doctor(String email, String password, String name, String uname) {
        this.uname = uname;
        this.password = password;
        this.name = name;
        this.name = name;
    }


    public String name() {
        if (this.name != null) {
            return this.name;
        }
        return "-1";
    }


}
