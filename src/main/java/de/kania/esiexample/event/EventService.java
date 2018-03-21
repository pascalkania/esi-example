package de.kania.esiexample.event;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class EventService {

    public List<Event> generateTenEvents() {
        List<Event> liste = new ArrayList<>();
        IntStream.range(0,10).forEach((p)->{
            liste.add(new Event());
        });
        return liste;
    }

    public Flux<Event> getLiveEvents(){
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
        Flux<Event> eventFlux = Flux.fromStream(Stream.generate(() -> new Event()));
        return Flux.zip(interval, eventFlux).map(t -> t.getT2());
    }
}
