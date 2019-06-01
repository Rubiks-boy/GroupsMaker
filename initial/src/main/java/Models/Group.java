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
    private Set<Competitor> competing;
    private Map<String, Set<Competitor>> helpingRoles;

    public Group(String eventName, List<String> roles) {
        this.eventName = eventName;
        this.competing = new HashSet<>();
        this.helpingRoles = new HashMap<>();
        for(String role: roles) {
            helpingRoles.put(role, new HashSet<>());
        }
    }

    public void addCompeting(Competitor competitor) {
        this.competing.add(competitor);
    }

    public void remCompeting(Competitor competitor) {
        this.competing.remove(competitor);
    }

    public Set<Competitor> getCompeting() {
        return competing;
    }

    public void addToRole(String role, Competitor competitor) {
        this.helpingRoles.get(role).add(competitor);
    }

    public void remFromRole(String role, Competitor competitor) {
        this.helpingRoles.get(role).remove(competitor);
    }

    public Set<Competitor> getInRole(String role) {
        return helpingRoles.get(role);
    }
}
