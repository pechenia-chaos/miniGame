package game;

public class PaddleAI {
    private double x;
    private static int num=1;
    private static boolean revers=true;
    private static boolean up=true;
    private static boolean down=false;

    private double randomX=300;
    private double y;
    private double speed;
    private double width;
    private double height;

    PaddleAI(double x, double y, double speed, double width, double height) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }
    public void update(double UpPole, double DownPole, double BallY, double BallX,
                       boolean BallUp, boolean BallDown) {
        if(BallX<60 || BallX >540) {
            setRandomX(300);
            setY((360/2)-30);

        }

        if(BallX==getX()) {
            int random = (int) (1 + Math.random() * 6);

            switch (random) {
                case 1:
                    setRandomX(300);
                    break;
                case 2:
                    setRandomX(240);
                    break;
                case 3:
                    setRandomX(240);
                    break;
                case 4:
                    setRandomX(120);
                    break;
                case 5:
                    setRandomX(180);
                    break;
                case 6:
                    setRandomX(180);
                    break;

            }

        }


        if(BallX<= getRandomX() && getRevers() == true) {

            if(!(getY()<=BallY && getY()+60 >=BallY)){
                if(BallY>getY()+30) {
                    setY(getY()+getSpeed());
                } else if (BallY<getY()+30) {
                    setY(getY()-getSpeed());
                }
            }


            if(BallX==60) { setRevers(false);}
        } else if(BallX >=300 ) {
            setRevers(true);
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
    private boolean getRevers() {
        return revers;
    }
    private double getRandomX() {
        return randomX;
    }
    private void setRandomX(double randomX) {
        this.randomX = randomX;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    private void setRevers(boolean revers) {
        this.revers=revers;
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



