package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Competitor {
    private String name;
    private String wcaId;
    private LocalDate birthDate;
    private Map<String, Boolean> events;
    private List<Helping> helpingIn;

    public Competitor(String name, String wcaId, LocalDate birthDate, Map<String, Boolean> events) {
        this.name = name;
        this.wcaId = wcaId;
        this.birthDate = birthDate;
        this.events = events;
        helpingIn = new ArrayList<>();
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

    public void addHelping(Helping helping) {
        helpingIn.add(helping);
    }

    public void removeHelping(Helping helping) {
        helpingIn.remove(helping);
    }

    public List<Helping> getHelpingIn() {
        return helpingIn;
    }

    @Override
    public String toString() {
        String str = String.format("%s %s %s", getName(), getWcaId(), getBirthDate().toString());
        for(String event : getEvents().keySet().stream().filter(event -> getEvents().get(event)).collect(Collectors.toList())) {
            str += " " + event;
        }
        for(Helping h : getHelpingIn()) {

        }
        return str;
    }
}
