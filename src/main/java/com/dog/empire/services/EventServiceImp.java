package com.dog.empire.services;

import com.dog.empire.dao.EventDao;
import com.dog.empire.exception.EntrepriseNotFoundException;
import com.dog.empire.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Component
@Service
public class EventServiceImp implements EventService{
    @Autowired
    private EventDao eventDao;
    @Override
    public Event getEventById(Long id) {
        Optional<Event> opt = eventDao.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            throw new EntrepriseNotFoundException("Veterinaire avec id : "+id+" n'exixte pas");
        }
    }

    @Override
    public List<Event> fetchEventList() {
        return (List<Event>)eventDao.findAll();
    }

    @Override
    public List<Event> getAllEvents() {
        return (List<Event>)eventDao.findAll();
    }
}
