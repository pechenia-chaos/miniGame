package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game extends JFrame {
    private static String text = "It's just a pong :)";
    private static double UpPole =0;
    private static double DownPole =300;
    private static double UpPoleforBall =0;
    private static double DownPoleforBall =360;
    private GamePanel gamePanel;
    private static Num num=new Num();
    private JFrame frame = new JFrame();
    private static KeyBoardinput keyBoardinput = new KeyBoardinput();
    private static Font font = new Font("Game", Font.PLAIN, 25);
    private static Font fontenter = new Font("Enter", Font.PLAIN, 10);



    public Game() {

        setTitle("PONG-GAME");
        setSize(618,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        gamePanel=new GamePanel();
        add(gamePanel);

    }

    private static class GamePanel extends JPanel {

        public GamePanel() {
            setFocusable(true);
            addKeyListener((KeyListener) keyBoardinput);
            Timer timer=new Timer(70, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!keyBoardinput.getEnter()) {  updateGame();
                        render();
                    }
                }
            });
            timer.start();
        }

        Paddle paddle=new Paddle(540,(360/2)-30 , 30, 5, 60);
        Ball ball = new Ball(600/2,360/2, 10, 5, 5);
        PaddleAI paddleAI=new PaddleAI(60,(360/2)-30, 30, 5, 60);

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            if(keyBoardinput.getEnter()) {
                g.setFont(font);
                g.setColor(Color.WHITE);
                g.drawString(text, 210, 150);

                g.setFont(fontenter);
                g.setColor(Color.WHITE);
                g.drawString("Нажмите Enter чтобы начать", 230,340);

                g.drawString("W - вверх", 553, 345);
                g.drawString("S - вниз", 553, 357);

            } else if(!keyBoardinput.getEnter()) {




                g.setColor(Color.WHITE);
                g.fillRect(300, 0, 1, 410);

//                    g.setColor(Color.CYAN);
//                    g.fillRect(0, 0, 700, 2);
//                    g.fillRect(0, 365, 700, 2);
//                    g.fillRect(0, 0, 2, 400);
//                    g.fillRect(600, 0, 2, 400);

                g.setColor(Color.WHITE);
                g.fillRect((int) paddle.getX(), (int) paddle.getY(),
                        (int) paddle.getWidth(), (int) paddle.getHeight());

                g.setColor(Color.WHITE);
                g.fillRect((int) paddleAI.getX(), (int) paddleAI.getY(),
                        (int) paddleAI.getWidth(), (int) paddleAI.getHeight());

                g.setColor(Color.WHITE);
                g.fillRect((int) ball.getX(), (int) ball.getY(),
                        (int) ball.getWidth(), (int) ball.getHeight());

                g.drawString(Integer.toString(num.getNumpaddle()), 310, 20);
                g.drawString(Integer.toString(num.getNumpaddleAI()), 283, 20);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600,400);
        }
        public void updateGame () {


            paddle.update(keyBoardinput.getUp(), keyBoardinput.getDown(),
                    UpPole, DownPole);
            ball.update(UpPoleforBall, DownPoleforBall, paddle.getX(), paddle.getY(),
                    paddleAI.getX(), paddleAI.getY());
            paddleAI.update(UpPole, DownPole, ball.getY(), ball.getX(),
                    ball.getBallUp(), ball.getBallDown());


        }



        public void render() {

            repaint();

        }



    }
}