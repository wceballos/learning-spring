package com.example.learningspring.util;

import com.example.learningspring.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;

    public AppStartupEvent(RoomRepository roomRepository,
                           ReservationRepository reservationRepository,
                           GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);

        Iterable<Guest> guests = this.guestRepository.findAll();
        guests.forEach(System.out::println);

        Iterable<Reservation> reservations = this.reservationRepository.findAllByDate(Date.valueOf("2022-01-01"));
        reservations.forEach(System.out::println);
    }
}
