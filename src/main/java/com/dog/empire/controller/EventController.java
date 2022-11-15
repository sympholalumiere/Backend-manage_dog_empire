package com.dog.empire.controller;

import com.dog.empire.dao.EventDao;
import com.dog.empire.model.Event;
import com.dog.empire.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/dogempire/")
@RestController
class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private EventDao eventDao;


    @GetMapping(value ="/events/liste")
    public List<Event> getAllEntreprises(){
        List<Event> liste= new ArrayList<>();
        eventService.fetchEventList().forEach(liste::add);
        return liste;
    }
    @RequestMapping(value="/event", method=RequestMethod.POST)
    public Event addEvent(@RequestBody Event event) {
        Event created = eventDao.save(event);
        return created;
    }

    @RequestMapping(value="/event", method=RequestMethod.PATCH)
    public Event updateEvent(@RequestBody Event event) {
        return eventDao.save(event);
    }

    @RequestMapping(value="/event", method=RequestMethod.DELETE)
    public void removeEvent(@RequestBody Event event) {
        eventDao.delete(event);
    }
}
