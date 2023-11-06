package game;

public class Ball {
    private Num num = new Num();
    private int number=0;
    private int numberAI =0;
    private int otskok=0;

    private static int plusSpeed=10;
    private boolean BallUp;
    private boolean BallDown;
    private boolean left=false;
    private boolean right=false;
    public boolean Start=true;
    private double x;
    private double y;
    private double speed;
    private double width;
    private double height;
    Ball(double x, double y, double speed, double width, double height) {
        this.x = x;
        this.y=y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }
    public void update(double UpPoleforBall, double DownPoleforBall,double paddleX, double paddleY,
                       double paddleAIX, double paddleAIY) {


        if (getStart()) {
            setBallUp(false);
            setBallDown(false);
            setLeft(false);
            setRight(false);

            int random = (int) (1 + Math.random() * 2);
            if (random == 1) {
                setRight(true);
                int random1 = (int) (1 + Math.random() * 2);
                if(random1 == 1) {
                    setY(getY() + speed);
                    setX(getX() + speed);
                    setBallUp(true);
                }
                else if (random1 == 2) {
                    setY(getY() - speed);
                    setX(getX() + speed);
                    setBallDown(true);
                }
            }
            else if (random == 2) {
                setLeft(true);
                int random2 = (int) (1 + Math.random() * 2);
                if(random2 == 1) {
                    setY(getY() - speed);
                    setX(getX() - speed);
                    setBallUp(true); }

                else if (random2 == 2) {
                    setY(getY() + speed);
                    setX(getX() - speed);
                    setBallDown(true);
                }
            }


            setStart(false);
        }

        else if (getX() <= 0 || getX() >= 595) {
            if(getX()<=0) {
                num.setNumpaddle(++number);
            } else if (getX() >= 595) {
                num.setNumpaddleAI(++numberAI);
            }
            setX(600/2);
            setY(360/2);
            setStart(true);
            setSpeed(10);
            otskok=0;
        }

        else {
            if(getY()-getSpeed()<UpPoleforBall) {
                setY(UpPoleforBall);
            } if(getY()+speed>DownPoleforBall) {
                setY(DownPoleforBall);
            }

            if (getY()== UpPoleforBall || getY() == DownPoleforBall) {

                if(getBallUp()) {
                    if (getRight()) {
                        if (getY() == UpPoleforBall) {
                            setY(getY()+speed);
                            setX(getX()+speed);
                            setBallDown(true);
                            setBallUp(false);
                        }
                    } else if(getLeft()) {
                        if (getY() == UpPoleforBall) {
                            setY(getY()+speed);
                            setX(getX()-speed);
                            setBallUp(false);
                            setBallDown(true);
                        }
                    }
                }
                else if(getBallDown()) {
                    if (getRight()) {
                        if (getY() == DownPoleforBall) {
                            setY(getY()-speed);
                            setX(getX()+speed);
                            setBallUp(true);
                            setBallDown(false);
                        }
                    } else if(getLeft()) {
                        if (getY() == DownPoleforBall) {
                            setY(getY()-speed);
                            setX(getX()-speed);
                            setBallUp(true);
                            setBallDown(false);
                        }
                    }
                }
            }


            else if(getY()>= paddleY && getY() <=paddleY+60 && getX() == paddleX ) {
                if (getRight()) {
                    if (getBallUp()) {

                        otskok++;
                        setY(getY() - speed);
                        setX(getX() - speed);
                        setLeft(true);
                        setRight(false);
                        if(getSpeed()<20 && otskok %3==0) {
                            setSpeed(getSpeed()+plusSpeed);
                        } if(getSpeed()==20 && getX()%20!=0 && getY()%20!=0) {
                            setX(getX()-10);
                            setY(getY()-10);
                        }
                    }
                    else if (getBallDown()) {
                        otskok++;
                        setY(getY() + speed);
                        setX(getX() - speed);
                        setLeft(true);
                        setRight(false);
                        if(getSpeed()<20 && otskok %3==0) {
                            setSpeed(getSpeed()+plusSpeed);
                        } if(getSpeed()==20 && getX()%20!=0 && getY()%20!=0) {
                            setX(getX()-10);
                            setY(getY()+10);
                        }

                    }
                }
            }

            else if (getY() >= paddleAIY && getY() <= paddleAIY+60 &&  getX() == paddleAIX ) {
                if(getLeft()) {
                    if(getBallUp()) {
                        otskok++;
                        setY(getY()-speed);
                        setX(getX()+speed);
                        setRight(true);
                        setLeft(false);
                        if(getSpeed()<20 && otskok %3==0) {
                            setSpeed(getSpeed()+plusSpeed);
                        } if(getSpeed()==20 && getX()%20!=0 && getY()%20!=0) {
                            setX(getX()+10);
                            setY(getY()-10);
                        }


                    }
                    else if(getBallDown()) {
                        otskok++;
                        setY(getY()+speed);
                        setX(getX()+speed);
                        setRight(true);
                        setLeft(false);
                        if(getSpeed()<20 && otskok %3==0) {
                            setSpeed(getSpeed()+plusSpeed);
                        } if(getSpeed()==20 && getX()%20!=0 && getY()%20!=0) {
                            setX(getX()+10);
                            setY(getY()+10);
                        }

                    }
                }
            }




            else {
                if(getRight()) {
                    if(getBallUp()) {
                        setY(getY()-speed);
                        setX(getX()+speed);
                    }
                    else if(getBallDown()) {
                        setY(getY()+speed);
                        setX(getX()+speed);
                    }
                } else if(getLeft()) {
                    if(getBallUp()) {
                        setY(getY()-speed);
                        setX(getX()-speed);
                    }
                    else if (getBallDown()) {
                        setY(getY()+speed);
                        setX(getX()-speed);
                    }

                }
            }
        }
    }
    public double getX() {
        return x;
    }
    public boolean getRight() {
        return right;
    }
    public boolean getLeft() {
        return left;
    }

    public boolean getBallUp() {
        return BallUp;
    }
    public boolean getBallDown() {
        return BallDown;
    }
    public double getY() {
        return y;
    }
    public boolean getStart() {
        return Start;
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
    public void setStart(boolean Start) {
        this.Start = Start;
    }
    private  void setBallUp(boolean BallUp) {
        this.BallUp = BallUp;
    }
    private void setBallDown(boolean BallDown) {
        this.BallDown = BallDown;
    }
    private void setLeft(boolean left) {
        this.left = left;
    }
    private void setRight(boolean right) {
        this.right = right;
    }


}
