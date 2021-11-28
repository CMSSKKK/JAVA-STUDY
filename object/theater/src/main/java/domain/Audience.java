package domain;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public int buyTicket(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0;
        }

        bag.minusMoney(ticket.getFee());
        bag.setTicket(ticket);
        return ticket.getFee();
    }

    public boolean hasTicket() {
        return bag.hasTicket();
    }
}
