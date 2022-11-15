package com.dog.empire.dao;

import com.dog.empire.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface EventDao extends JpaRepository<Event, Long> {


    Event save(Event event);
    void delete(Event event);

    /* This one uses an @Query
    @Query("select b from Event b where b.start >= ?1 and b.end <= ?2")
    public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);
*/
}
