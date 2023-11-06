package game;

public class Paddle {
    KeyBoardinput keyBoardinput = new KeyBoardinput();
    private double x;
    private double y;
    private double speed;
    private double width;
    private double height;

    Paddle(double x, double y, double speed, double width, double height) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public void update(boolean up, boolean down, double UpPole, double DownPole) {
        if (getY()== UpPole || getY()== DownPole) {
            if (getY()== UpPole) {
                if (up) {
                    setY(getY());
                } else if (down) {
                    setY(getY() + speed);
                }
            }

            else {
                if (up) {
                    setY(getY() - speed);
                } else if (down) {
                    setY(getY());
                }
            }
        }


        else {
            if (up) {
                setY(getY() - speed);
            } else if (down) {
                setY(getY() + speed);

            }
        }

    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getSpeed() {
        return speed;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
}
