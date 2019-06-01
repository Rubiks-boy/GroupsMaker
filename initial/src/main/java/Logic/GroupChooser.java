package Logic;

import Models.Competitor;
import Models.Group;

import java.util.*;

public class GroupChooser {
    public static int getBestGroupNumForCompeting(Competitor competitor, List<Group> groups) {
        groups = new ArrayList<>(groups);
        groups.sort(Comparator.comparingInt(g -> g.getCompeting().size()));

        for(int i = 0; i < groups.size(); i++) {
            if(! groups.get(i).getCompeting().contains(competitor))
                return groups.get(i).getGroupNum();
        }

        return groups.get(0).getGroupNum();
    }
}
