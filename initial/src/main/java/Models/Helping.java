package Models;

public class Helping {
    private char type;
    private int group;
    private char stage;

    public Helping(char type, int group, char stage) {
        this.type = type;
        this.group = group;
        this.stage = stage;
    }

    public char getType() {
        return type;
    }

    public int getGroup() {
        return group;
    }

    public char getStage() {
        return stage;
    }

    @Override
    public String toString() {
        return String.format("%s%d%s", type, group, stage);
    }
}
