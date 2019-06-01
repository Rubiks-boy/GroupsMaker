package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputCompetitor extends Competitor {
    List<Integer> competingGroups;
    List<String> helpingGroups;

    public OutputCompetitor(Competitor competitor, int numEvents) {
        super(competitor.getName(), competitor.getWcaId(), competitor.getBirthDate(), competitor.getEvents());
        competingGroups = new ArrayList<>();
        helpingGroups = new ArrayList<>();
        for(int i = 0; i < numEvents; i++) {
            competingGroups.add(-1);
            helpingGroups.add("");
        }
    }

    public OutputCompetitor(String name, String wcaId, LocalDate birthDate, Map<String, Boolean> events) {
        super(name, wcaId, birthDate, events);
    }

    public void setCompetingGroups(List<Integer> competingGroups) {
        this.competingGroups = competingGroups;
    }

    public void setHelpingGroups(List<String> helpingGroups) {
        this.helpingGroups = helpingGroups;
    }

    public List<Integer> getCompetingGroups() {
        return competingGroups;
    }

    public List<String> getHelpingGroups() {
        return Collections.unmodifiableList(helpingGroups);
    }

    @Override
    public String toString() {
        String str = String.format("%s,%s,%s", getName(), getWcaId(), getBirthDate());
        for(int i = 0; i < competingGroups.size(); i++) {
            str += "," + (competingGroups.get(i)+1 == 0 ? "" : (competingGroups.get(i)+1)) + "," + helpingGroups.get(i);
        }
        str+= '\n';

        return str;
    }
}
