package Models;

import java.util.*;

public class GroupStorage {
    private Map<String, List<Group>> eventsGroups;

    public GroupStorage(List<String> eventsList, List<Integer> numGroups) {
        eventsGroups = new HashMap<>();
        for(int i = 0; i < eventsList.size(); i++) {
            String currEvent = eventsList.get(i);
            int currNumGroups = numGroups.get(i);
            List<Group> currEventGroups = new ArrayList<>();

            for(int j = 0; j < currNumGroups; j++) {
                currEventGroups.add(new Group(currEvent, j, Group.STANDARD_ROLES));
            }

            eventsGroups.put(currEvent, currEventGroups);
        }
    }

    public List<Group> getGroups(String event) {
        return Collections.unmodifiableList(eventsGroups.get(event));
    }
}
