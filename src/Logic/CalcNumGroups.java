package Logic;

import Models.Competitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CalcNumGroups {
    private static final int minMultiplier = 2;

    public static int calcNumGroupsForEvent(int numRegistered, int numStations) {
        int numGroups = Math.round((float)(numRegistered) / (numStations*minMultiplier));

        return numGroups >= 2 ? numGroups : 2;
    }

    public static List<Integer> calcNumGroups(Map<String, Set<Competitor>> eventRegs, List<String> events, int numStations) {
        List<Integer> numGroups = new ArrayList<>();

        for(int i = 0; i < events.size(); i++) {
            numGroups.add(calcNumGroupsForEvent(eventRegs.get(events.get(i)).size(), numStations));
        }

        return numGroups;
    }
}
