package Models;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class Competitor {
    private String name;
    private String wcaId;
    private LocalDate birthDate;
    private Map<String, Boolean> events;

    public Competitor(String name, String wcaId, LocalDate birthDate, Map<String, Boolean> events) {
        this.name = name;
        this.wcaId = wcaId;
        this.birthDate = birthDate;
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public String getWcaId() {
        return wcaId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Map<String, Boolean> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        String str = String.format("%s %s %s", getName(), getWcaId(), getBirthDate().toString());
        for(String event : getEvents().keySet().stream().filter(event -> getEvents().get(event)).collect(Collectors.toList())) {
            str += " " + event;
        }
        return str;
    }
}
