package toy;

public enum Direction {
    RIGHT(3),
    LEFT(5),
    UP(7),
    DOWN(9);

    private int distance;
    Direction(int distance) {
        this.distance = distance;
    }

    public boolean isRIGHT() {
        return this == RIGHT;
    }

    public boolean isLEFT() {
        return this == LEFT;
    }

    public boolean isUP() {
        return this == UP;
    }

    public boolean isDOWN() {
        return this == DOWN;
    }

    public int getDistance() {
        return this.distance;
    }
}
