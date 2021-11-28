package domainTest;

import domain.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketTest {

    @Test
    @DisplayName("ticket의 가격은 10000원이며 변경할 수 없다")
    void ticket_fee_test() {
        Ticket ticket = new Ticket();
        Assertions.assertThat(ticket.getFee()).isEqualTo(10000);
    }


}
