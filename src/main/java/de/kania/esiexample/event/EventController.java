package de.kania.esiexample.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public List<Event> listEvents(){
        return eventService.generateTenEvents();
    }


    @GetMapping(path = "/stream", produces = "text/event-stream")
    public Flux<Event> liveEvents(){
        System.out.println("LiveEvents werden aufgerufen");
        return eventService.getLiveEvents();
    }
}
