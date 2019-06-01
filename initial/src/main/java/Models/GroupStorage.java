package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupStorage {
    private Map<String, List<Group>> eventsGroups;

    public GroupStorage(List<String> eventsList, List<Integer> numGroups) {
        eventsGroups = new HashMap<>();
        for(int i = 0; i < eventsList.size(); i++) {
            String currEvent = eventsList.get(i);
            int currNumGroups = numGroups.get(i);
            List<Group> currEventGroups = new ArrayList<>();

            for(int j = 0; j < currNumGroups; j++) {
                currEventGroups.add(new Group(currEvent, Group.STANDARD_ROLES));
            }
        }
    }

    public List<Group> getGroups(String event) {
        return eventsGroups.get(event);
    }
}
