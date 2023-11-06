package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardinput implements KeyListener {
    private boolean enter =true;
    private boolean up = false;
    private boolean down = false;

    public KeyBoardinput() {
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enter = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_W) {

            up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {

            down = true;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enter = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_W) {
            up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            down = false;
        }
    }

    public boolean getUp() {
        return up;
    }

    public boolean getDown() {

        return down;
    }
    public boolean getEnter() {
        return enter;
    }
    public void setEnter(boolean enter) {
        this.enter = enter;
    }
}
