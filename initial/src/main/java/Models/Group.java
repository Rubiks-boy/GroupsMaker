package Models;

import java.util.*;

public class Group {
    public static final List<String> STANDARD_ROLES = new ArrayList<>();

    static {
        STANDARD_ROLES.add("J");
        STANDARD_ROLES.add("R");
        STANDARD_ROLES.add("S");
        STANDARD_ROLES.add("D");
    }

    private String eventName;
    private int groupNum;
    private Set<Competitor> competing;
    private Map<String, Set<Competitor>> helpingRoles;

    public Group(String eventName, int groupNum, List<String> roles) {
        this.eventName = eventName;
        this.groupNum = groupNum;
        this.competing = new HashSet<>();
        this.helpingRoles = new HashMap<>();
        for(String role: roles) {
            helpingRoles.put(role, new HashSet<>());
        }
    }

    public String getEventName() {
        return eventName;
    }

    public void addCompeting(Competitor competitor) {
        this.competing.add(competitor);
    }

    public void remCompeting(Competitor competitor) {
        this.competing.remove(competitor);
    }

    public Set<Competitor> getCompeting() {
        return Collections.unmodifiableSet(competing);
    }

    public void addToRole(String role, Competitor competitor) {
        this.helpingRoles.get(role).add(competitor);
    }

    public void remFromRole(String role, Competitor competitor) {
        this.helpingRoles.get(role).remove(competitor);
    }

    public int getGroupNum() {
        return groupNum;
    }

    public Set<Competitor> getInRole(String role) {
        return Collections.unmodifiableSet(helpingRoles.get(role));
    }
}
