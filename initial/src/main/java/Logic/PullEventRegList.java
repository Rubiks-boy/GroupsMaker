package Logic;

import Models.Competitor;

import java.util.*;
import java.util.stream.Collectors;

public class PullEventRegList {
    public static Map<String, Set<Competitor>> convertAllCompetitorsIntoEventRegistrations(Set<Competitor> competitors, List<String> eventNames) {
        Map<String, Set<Competitor>> eventRegs = new HashMap<>();
        for(String event: eventNames) {
            eventRegs.put(event, competitors.stream().filter(c -> c.getEvents().get(event)).collect(Collectors.toSet()));
        }

        return eventRegs;
    }
}
