package com.dog.empire.services;


import com.dog.empire.model.Event;

import java.util.List;

public interface EventService {
    //get by id
    public Event getEventById(Long id);



    // Read operation
    List<Event> fetchEventList();
    public List<Event> getAllEvents();

}
