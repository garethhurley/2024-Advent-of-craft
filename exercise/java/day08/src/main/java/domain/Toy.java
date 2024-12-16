package domain;

public class Toy {

    public enum State {
        UNASSIGNED, IN_PRODUCTION, COMPLETED;
    }
    private final String name;

    private State state;

    public Toy(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public boolean moveToProduction() {
        if(this.state == State.UNASSIGNED) {
            this.state = State.IN_PRODUCTION;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

}