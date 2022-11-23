package com.dog.empire.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idEvent;
    @Column(name = "text", nullable = false)
    String text;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "debut", nullable = false)
    @JsonIgnore
    private Date debut;

    @LastModifiedDate
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fin")
    @JsonIgnore
    private Date fin;

    @Column(name = "color", nullable = false)
    String color;
}
