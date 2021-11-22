package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import toy.NoMovableException;
import toy.Position;
import toy.Toy;

import static org.assertj.core.api.Assertions.*;
import static toy.Direction.*;
import static toy.Direction.RIGHT;

public class enumTest {

    // 1.toy 객체 안에 이름과 방향(enum)이 설정되어있음
    // 2.default enum은 RIGHT
    // 3.객체안의 enum 체크하기
    // 4.객체를 생성할 때 enum을 설정해줌
    // 5.enum의 distance 확인하기
    // 6.toy의 포지션 설정하기 default = 0 0
    // 7.toy move 구현하기 direction의 distance만큼 움직이는 것으로 구현
    //      좌우는 x가 움직이고 상하는 y가 움직이는 방식
    // 8.toy의 에너지를 만들고 move()할때마다 소비하는 것을 구현 enum에 상수를 추가하여 abstract 메서드 구현해보기
    // 9. toy의 에너지 상태로 movable를 만들고 에너지를 다 소비하면 움직이지 못하는 상태 점검하기


    @Test
    @DisplayName("enum찾기")
    void findEnum() {

        Toy toy = new Toy("aaron");
        assertThat(toy.enumCheck()).isEqualTo(RIGHT);
    }

    @Test
    @DisplayName("enum확인하기")
    void findEnum2() {

        Toy toy = new Toy("aaron", LEFT);
        assertThat(toy.enumCheck()).isEqualTo(LEFT);
    }

    @Test
    @DisplayName("enum확인하기")
    void findEnum3() {
        Toy toy = new Toy("aaron", LEFT);
        assertThat(toy.enumCheck().getDistance()).isEqualTo(5);
    }

    @Test
    @DisplayName("toy의 포지션 설정하기")
    void toySetPosition() {

        Toy toy = new Toy("aaron", LEFT);
        assertThat(toy.positionX()).isEqualTo(new Position().getX());
        assertThat(toy.positionY()).isEqualTo(new Position().getY());
        Position position = new Position(3, 8);
        Toy toy2 = new Toy("aaron", DOWN, position);
        assertThat(toy2.positionX()).isEqualTo(3);
        assertThat(toy2.positionY()).isEqualTo(8);

    }

    @Test
    @DisplayName("toy move 구현하기")
    void toyMove() throws NoMovableException {

        Toy toy = new Toy("aaron", LEFT);

        toy.move();
        assertThat(toy.positionX()).isEqualTo(-5);
        assertThat(toy.positionY()).isEqualTo(0);
        assertThat(toy.CurrentPosition()).isEqualTo("위치는"+-5+" "+0+"입니다.");
    }

    @Test
    @DisplayName("toy의 체력 및 move할때마다 energy가 줄어드는 것 확인하기")
    void toyHasEnergyTest() throws NoMovableException {

        Toy toy = new Toy("aaron", LEFT);
        assertThat(toy.currentEnergy()).isEqualTo(100);
        toy.move();
        assertThat(toy.currentEnergy()).isNotEqualTo(100);
        assertThat(toy.currentEnergy()).isEqualTo(90);
    }
    @Test
    @DisplayName("toy의 상태 확인하기")
    void toyMovableTest() throws NoMovableException {
        Toy toy = new Toy("aaron", LEFT);
        for (int i = 0; i < 10 ; i++) {
            toy.move();
        }

        Assertions.assertThrows(NoMovableException.class, () ->toy.move());

   }
 }
