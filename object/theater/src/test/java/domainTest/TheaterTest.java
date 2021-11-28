package domainTest;

import domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TheaterTest {

    @Test
    @DisplayName("티켓이 있는 관객은 입장 시킨다.")
    void enter_hasTicket() {
        Theater theater = new Theater();
        Bag bag = new Bag(10000);
        Audience audience = new Audience(bag);
        TicketOffice ticketOffice = new TicketOffice(10,0);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        ticketSeller.sellTo(audience);
        assertThat(theater.enter(audience)).isTrue();
    }

    @Test
    @DisplayName("티켓이 없는 관객은 입장 시키지 않는다.")
    void doesnt_enter_hasTicket() {
        Theater theater = new Theater();
        Bag bag = new Bag(10000);
        Audience audience = new Audience(bag);
        assertThat(theater.enter(audience)).isFalse();
    }
}
