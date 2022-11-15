package com.dog.empire.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @Column(name = "text")
    String text;

    @Column(name = "start")
    LocalDateTime start;
    @Column(name = "end")
    LocalDateTime end;
    @Column(name = "color")
    String color;
}
