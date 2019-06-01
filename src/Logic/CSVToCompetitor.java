package Logic;

import Models.Competitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static java.lang.Integer.parseInt;

public class CSVToCompetitor {
    private List<String> eventsList;
    private Set<Competitor> competitors;

    private void makeEventsList(String headerStr) {
        eventsList = new ArrayList<>();
        String[] splitLine = headerStr.split(",");

        for (int i = 6; i < splitLine.length - 1 - 3; i++) {
            eventsList.add(splitLine[i]);
        }
    }

    private Competitor lineToCompetitor(String line, List<String> eventsList) {
        //split line according to commas
        String[] splitLine = line.split(",");

        //get name and wcaid
        String name = splitLine[1];
        String wcaId = splitLine[3];

        //extract birthdate
        String bdStr = splitLine[4];
        LocalDate birthDate = LocalDate.of(parseInt(bdStr.substring(0, 4)), parseInt(bdStr.substring(5, 7)), parseInt(bdStr.substring(8, 10)));

        //calculate which events
        int numEvents = eventsList.size();
        Map<String, Boolean> events = new HashMap<>();

        for (int i = 0; i < numEvents; i++) {
            events.put(eventsList.get(i), (splitLine[6 + i].equals("1")));
        }

        return new Competitor(name, wcaId, birthDate, events);
    }

    public void extractCompetitorsList(BufferedReader file) {
        competitors = new HashSet<>();

        try {
            makeEventsList(file.readLine());
            String line = "";

            while((line = file.readLine()) != null) {
                competitors.add(lineToCompetitor(line, eventsList));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CSVToCompetitor(BufferedReader file) {
        extractCompetitorsList(file);
    }

    public List<String> getEventsList() {
        return eventsList;
    }

    public Set<Competitor> getCompetitors() {
        return Collections.unmodifiableSet(competitors);
    }
}
