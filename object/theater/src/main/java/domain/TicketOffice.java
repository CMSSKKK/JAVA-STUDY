package domain;

public class TicketOffice {


    private int ticketQuantity;
    private int money;

    public TicketOffice(int ticketQuantity, int money) {
        this.ticketQuantity = ticketQuantity;
        this.money = money;
    }


    public boolean hasTicket() {
        if(ticketQuantity == 0) {
            return false;
        }
        return true;
    }

    public Ticket getTicket() {
        if(!this.hasTicket()) {
            throw new IllegalArgumentException();
        }
        this.ticketQuantity -= 1;
        return new Ticket();
    }

    public int getQuantity() {
        return this.ticketQuantity;
    }

    public void plusMoney(int fee) {
        this.money += fee;
    }

    public int checkMoney() {
        return this.money;
    }
}
