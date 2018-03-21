package de.kania.esiexample.event;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Event {

    private List<String> eventTitles = List.of("Flightshow","carshow","Football", "NBA");

    private final String id;

    private final String titel;
    public Event(){
        this.id = UUID.randomUUID().toString();
        this.titel = getRandomEventTitle();
    }

    private String getRandomEventTitle() {
        return eventTitles.get(new Random().nextInt(eventTitles.size()));
    }

    public String getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

}
