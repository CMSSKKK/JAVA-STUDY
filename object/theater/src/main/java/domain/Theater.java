package domain;

public class Theater {


    public boolean enter(Audience audience) {
        if (audience.hasTicket()) {
            return true;
        }

        return false;
    }
}
