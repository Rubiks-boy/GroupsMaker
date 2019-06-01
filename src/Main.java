import Logic.*;
import Models.Competitor;
import Models.Group;
import Models.GroupStorage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        String log = "";

        try {

            String csvFile = System.getProperty("user.home") + "/desktop/registration.csv";
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(csvFile));
            } catch (FileNotFoundException e) {
                log += "Error reading file\n" + e.getStackTrace();
            }

            CSVToCompetitor csvToCompetitor = new CSVToCompetitor(br);

            log += String.format("loaded in %d competitors\n", csvToCompetitor.getCompetitors().size());

            Map<String, Set<Competitor>> eventRegs = PullEventRegList.convertAllCompetitorsIntoEventRegistrations(csvToCompetitor.getCompetitors(), csvToCompetitor.getEventsList());

            log += "event breakdown:\n";
            for (int i = 0; i < csvToCompetitor.getEventsList().size(); i++) {
                log += String.format("\t%d competitors registered in %s\n", eventRegs.get(csvToCompetitor.getEventsList().get(i)).size(), csvToCompetitor.getEventsList().get(i));
            }

            List<Integer> numGroups = CalcNumGroups.calcNumGroups(eventRegs, csvToCompetitor.getEventsList(), 12);

            log += "event: numGroups\n";
            for (int i = 0; i < csvToCompetitor.getEventsList().size(); i++) {
                log += String.format("%s: %d\n", csvToCompetitor.getEventsList().get(i), numGroups.get(i));
            }

            GroupStorage groupStorage = new GroupStorage(csvToCompetitor.getEventsList(), numGroups);

            for (String event : csvToCompetitor.getEventsList())
                GroupChooser.assignCompetingGroups(eventRegs.get(event), groupStorage.getGroups(event));

            log += "Event: GroupNum: #CompetitorsAssigned\n";
            for (int i = 0; i < csvToCompetitor.getEventsList().size(); i++) {
                String event = csvToCompetitor.getEventsList().get(i);
                List<Group> groups = groupStorage.getGroups(event);
                for (int j = 0; j < groups.size(); j++) {
                    log += String.format("\t%s: %d: %d\n", event, j + 1, groups.get(j).getCompeting().size());
                }
            }

            CollapseToOutputFile.collapseToOutputCSV(groupStorage, csvToCompetitor.getCompetitors(), csvToCompetitor.getEventsList());
            log += "File successfully made.";
        } catch (Exception e) {
            e.printStackTrace();
            log += e.getStackTrace();
        }
        System.out.println(log);
    }

}
