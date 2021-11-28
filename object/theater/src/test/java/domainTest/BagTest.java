package domainTest;

import domain.Bag;
import domain.Invitation;
import domain.Ticket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BagTest {

    @Test
    @DisplayName("bag에는 돈,초대장,티켓이 있을 수 있다.")
    void bag_돈_초대장() {
        Invitation invitation = new Invitation(10);
        Bag bag = new Bag(10000, invitation);
        assertThat(bag.getMoney()).isEqualTo(10000);
        assertThat(bag.hasInvitation()).isTrue();
        assertThat(bag.hasTicket()).isFalse();
    }

    @Test
    @DisplayName("bag에는 돈,초대장,티켓이 있을 수 있다.")
    void bag_돈() {
        Bag bag = new Bag(10000);
        assertThat(bag.getMoney()).isEqualTo(10000);
        assertThat(bag.hasInvitation()).isFalse();
        assertThat(bag.hasTicket()).isFalse();
    }

    @Test
    @DisplayName("티켓은 구매하거나 초대장으로 교환하면 생긴다.")
    void setTicket() {
        Invitation invitation = new Invitation(10);
        Bag bag = new Bag(10000,invitation);
        assertThat(bag.hasTicket()).isFalse();

        Ticket ticket = new Ticket();
        bag.setTicket(ticket);
        assertThat(bag.hasTicket()).isTrue();
    }

    @Test
    @DisplayName("돈을 사용하면(티켓구매) 그만큼의 액수가 차감된다.")
    void minus_money_test() {
        Bag bag = new Bag(10000);
        bag.minusMoney(3000);
        assertThat(bag.getMoney()).isEqualTo(7000);
    }

}
