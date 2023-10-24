package com.example.learningspring.business;

import com.example.learningspring.data.Guest;
import com.example.learningspring.data.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuests() {
        List<Guest> guests = new ArrayList<>();
        guestRepository.findAll().forEach(guests::add);

        // Sort ascending by last name
        guests.sort((Guest a, Guest b) -> {
            if (a.getLastName().equals(b.getLastName())) {
                return a.getFirstName().compareTo(b.getFirstName());
            }
            return a.getLastName().compareTo(b.getLastName());
        });

        return guests;
    }
}
