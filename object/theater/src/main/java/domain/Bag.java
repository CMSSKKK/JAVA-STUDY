package domain;

public class Bag {
    private int money;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(int money, Invitation invitation) {
        this.money = money;
        this.invitation = invitation;
        this.ticket = null;
    }

    public Bag(int money) {
        this(money,null);
    }

    public int getMoney() {
        return this.money;
    }

    public boolean hasInvitation() {
        if(this.invitation == null) {
            return false;
        }
        return true;
    }

    public boolean hasTicket() {
        if(this.ticket == null) {
            return false;
        }
        return true;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusMoney(int amount) {
        this.money -= amount;
    }
}
