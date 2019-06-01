package Logic;

import Models.Competitor;
import Models.Group;
import Models.GroupStorage;
import Models.OutputCompetitor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CollapseToOutputFile {
    public static void collapseToOutputCSV(GroupStorage groupStorage, Set<Competitor> competitors, List<String> eventsList) {
        Map<String, OutputCompetitor> outputCompetitors = new HashMap<>();

        for(Competitor c : competitors) {
            outputCompetitors.put(c.getName(), new OutputCompetitor(c, eventsList.size()));
        }

        for(int i = 0; i < eventsList.size(); i++) {
            List<Group> groups = groupStorage.getGroups(eventsList.get(i));

            for(int j = 0; j < groups.size(); j++) {
                Group group = groups.get(j);
                for(Competitor competitor : group.getCompeting()) {
                    outputCompetitors.get(competitor.getName()).getCompetingGroups().set(i, group.getGroupNum());
                }
            }
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "/desktop/regOut.csv"));

            String headerLine = "Name,wcaID,birthDate";
            for(int i = 0; i < eventsList.size(); i++) {
                headerLine += "," + eventsList.get(i) + ",H" + eventsList.get(i);
            }
            headerLine += "\n";
            bw.write(headerLine);

            outputCompetitors.values().stream().forEach(oc -> {
                try {
                    bw.write(oc.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
