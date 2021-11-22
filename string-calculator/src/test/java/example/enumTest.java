package example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import toy.Position;
import toy.Toy;

import static org.assertj.core.api.Assertions.*;
import static toy.Direction.*;
import static toy.Direction.RIGHT;

public class enumTest {

    @Test
    @DisplayName("enum찾기")
    void findEnum() {
        // 1.toy 객체 안에 이름과 방향(enum)이 설정되어있음
        // 2.default enum은 RIGHT
        // 3.객체안의 enum 체크하기
        Toy toy = new Toy("aaron");
        assertThat(toy.enumCheck()).isEqualTo(RIGHT);
    }
    @Test
    @DisplayName("enum확인하기")
    void findEnum2() {
        // 1.toy 객체 안에 이름과 방향(enum)이 설정되어있음
        // 2.default enum은 RIGHT
        // 3.객체안의 enum 체크하기
        // 4.객체를 생성할 때 enum을 설정해줌
        Toy toy = new Toy("aaron", LEFT);
        assertThat(toy.enumCheck()).isEqualTo(LEFT);
    }
    @Test
    @DisplayName("enum확인하기")
    void findEnum3() {
        // 1.toy 객체 안에 이름과 방향(enum)이 설정되어있음
        // 2.default enum은 RIGHT
        // 3.객체안의 enum 체크하기
        // 4.객체를 생성할 때 enum을 설정해줌
        // 5.enum의 distance 확인하기

        Toy toy = new Toy("aaron", LEFT);
        assertThat(toy.enumCheck().getDistance()).isEqualTo(5);
    }

    @Test
    @DisplayName("toy의 포지션 설정하기")
    void toySetPosition() {
        // 1.toy 객체 안에 이름과 방향(enum)이 설정되어있음
        // 2.default enum은 RIGHT
        // 3.객체안의 enum 체크하기
        // 4.객체를 생성할 때 enum을 설정해줌
        // 5.enum의 distance 확인하기
        // 6.toy의 포지션 설정하기 default = 0 0
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
    void toyMove() {
        // 1.toy 객체 안에 이름과 방향(enum)이 설정되어있음
        // 2.default enum은 RIGHT
        // 3.객체안의 enum 체크하기
        // 4.객체를 생성할 때 enum을 설정해줌
        // 5.enum의 distance 확인하기
        // 6.toy의 포지션 설정하기 default = 0 0
        // 7.toy move 구현하기 direction의 distance만큼 움직이는 것으로 구현
        //      좌우는 x가 움직이고 상하는 y가 움직이는 방식
        Toy toy = new Toy("aaron", LEFT);
        assertThat(toy.positionX()).isEqualTo(new Position().getX());
        assertThat(toy.positionY()).isEqualTo(new Position().getY());
        Position position = new Position(3, 8);
        Toy toy2 = new Toy("aaron", DOWN, position);
        assertThat(toy2.positionX()).isEqualTo(3);
        assertThat(toy2.positionY()).isEqualTo(8);

    }
}
