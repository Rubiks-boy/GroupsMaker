package Logic;

import java.util.List;

public class CalcNumGroups {
    private static final int minMultiplier = 2;

    public static int calcNumGroupsForEvent(int numRegistered, int numStations) {
        int numGroups = Math.round((float)(numRegistered + 0.0 / numStations));

        return numGroups >= 2 ? numGroups : 2;
    }
}
