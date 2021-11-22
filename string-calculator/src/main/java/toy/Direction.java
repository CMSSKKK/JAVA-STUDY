package toy;

public enum Direction {
    // 추상메서드를 사용해보려고 이렇게 작성했지만 지금 현재 내코드로는 굳이 추상메서드로 구현할 필요가 없다.
    RIGHT(3) {
        @Override
        int energyCost() {
            return Math.abs(getDistance()*COST);
        }
    },
    LEFT(-5){
        @Override
        int energyCost() {
            return Math.abs(getDistance()*COST);
        }
    },
    UP(7){
        @Override
        int energyCost() {
            return Math.abs(getDistance()*COST);
        }
    },
    DOWN(-9){
        @Override
        int energyCost() {
            return Math.abs(getDistance()*COST);
        }
    };

    private int distance;
    Direction(int distance) {
        this.distance = distance;
    }

    protected final static int COST = 2;

    abstract int energyCost();

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
