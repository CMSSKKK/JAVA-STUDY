package toy;

public class Toy {
    private String name;
    private Direction direction;
    private Position position;
    private int energy;

    public Toy(String name) {
        this.name = name;
        this.direction = Direction.RIGHT;
        this.position = new Position();
        this.energy = 100;
    }
    public Toy(String name,Direction direction) {
        this.name = name;
        this.direction = direction;
        this.position = new Position();
        this.energy = 100;
    }
    public Toy(String name, Direction direction, Position position) {
        this.name = name;
        this.direction = direction;
        this.position = position;
        this.energy = 100;
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

    public void move() {
        if(this.direction == Direction.RIGHT || this.direction == Direction.LEFT) {
             int positionX = this.positionX()+this.direction.getDistance();
             this.position.setX(positionX);
        }

        if(this.direction == Direction.UP || this.direction == Direction.DOWN) {
            int positionY = this.positionY()+this.direction.getDistance();
            this.position.setY(positionY);
        }
        this.energy = this.energy - this.direction.energyCost();
    }

    public String CurrentPosition() {
        return this.position.toString();
    }

    public int currentEnergy() {
        return this.energy;
    }


}
