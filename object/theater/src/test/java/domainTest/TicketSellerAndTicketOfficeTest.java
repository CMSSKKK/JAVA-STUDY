package domainTest;

import domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketSellerAndTicketOfficeTest {

    @Test
    @DisplayName("티켓 오피스에는 티켓 수량이 있으며 티켓교환(getTicket())을 하면 티켓수량이 줄어든다.")
    void ticketOfficeTest() {
        TicketOffice ticketOffice = new TicketOffice(100, 0);
        assertThat(ticketOffice.hasTicket()).isTrue();
        ticketOffice.getTicket();
        assertThat(ticketOffice.getQuantity()).isEqualTo(99);

    }

    @Test
    @DisplayName("티켓 오피스에는 티켓 수량이 없으면 구매불가하다")
    void ticketOffice_no_hasTicket_Test() {
        TicketOffice ticketOffice = new TicketOffice(10, 0);
        assertThat(ticketOffice.hasTicket()).isTrue();
        for (int i = 0; i <10 ; i++) {
            ticketOffice.getTicket();
        }
        assertThrows(RuntimeException.class, ()-> ticketOffice.getTicket());

    }

    @Test
    @DisplayName("티켓 오피스에는 초대장이 없는 관객에게 티켓을 교환해주면 돈을 얻는다.")
    void ticketOffice_getTicket() {
        TicketOffice ticketOffice = new TicketOffice(10, 0);
        Bag bag = new Bag(10000);
        Audience audience = new Audience(bag);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        ticketSeller.sellTo(audience);
        assertThat(ticketOffice.checkMoney()).isEqualTo(10000);

    }

    @Test
    @DisplayName("티켓 오피스에는 초대장이 있는 관객에게 티켓을 교환해주면 돈을 얻지 못한다.")
    void ticketOffice_getTicket_with_invitation() {
        TicketOffice ticketOffice = new TicketOffice(10, 0);
        Invitation invitation = new Invitation(1);
        Bag bag = new Bag(10000,invitation);
        Audience audience = new Audience(bag);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        ticketSeller.sellTo(audience);
        assertThat(ticketOffice.checkMoney()).isEqualTo(0);

    }

    @Test
    @DisplayName("티켓셀러가 티켓을 판매하면 관객은 티켓을 얻는다.")
    void sell_ticket_to_audience() {
        TicketOffice ticketOffice = new TicketOffice(10, 0);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Bag bag = new Bag(10000);
        Audience audience = new Audience(bag);
        ticketSeller.sellTo(audience);
        assertThat(audience.hasTicket()).isTrue();
    }
}
