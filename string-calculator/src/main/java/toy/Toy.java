package toy;

public class Toy {
    private String name;
    private Direction direction;
    private Position position;

    public Toy(String name) {
        this.name = name;
        this.direction = Direction.RIGHT;
        this.position = new Position();
    }
    public Toy(String name,Direction direction) {
        this.name = name;
        this.direction = direction;
        this.position = new Position();
    }
    public Toy(String name, Direction direction, Position position) {
        this.name = name;
        this.direction = direction;
        this.position = position;
    }


    public Direction enumCheck() {
        if(direction.isRIGHT()) {
            return direction;
        }
        if(direction.isLEFT()) {
            return direction;
        }
        if(direction.isUP()) {
            return direction;
        }
        if(direction.isDOWN()) {
            return direction;
        }


        throw new IllegalArgumentException();
    }

    public int positionX() {
        return this.position.getX();
    }

    public int positionY() {
        return this.position.getY();
    }


}
