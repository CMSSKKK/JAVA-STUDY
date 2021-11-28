package domainTest;

import domain.Audience;
import domain.Bag;
import domain.Invitation;
import domain.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AudienceTest {

    @Test
    @DisplayName("관객은 가방을 소지하고 있으며 티켓을 구매할 수 있다.")
    void audience_has_bag_and_buyTicket() {
        Bag bag = new Bag(10000);
        Audience audience = new Audience(bag);
        Ticket ticket = new Ticket();
        audience.buyTicket(ticket);
        assertThat(bag.getMoney()).isEqualTo(0);
        assertThat(bag.hasTicket()).isTrue();
    }

    @Test
    @DisplayName("관객은 초대장을 가지고 있으면 티켓으로 교환할 수 있다.")
    void audience_hasInvitiaion_change_ticket() {
        Invitation invitation = new Invitation(10);
        Bag bag = new Bag(10000,invitation);
        Audience audience = new Audience(bag);
        Ticket ticket = new Ticket();
        audience.buyTicket(ticket);
        assertThat(bag.getMoney()).isEqualTo(10000);
        assertThat(bag.hasTicket()).isTrue();
    }

}
