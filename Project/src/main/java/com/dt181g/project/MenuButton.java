//package com.dt181g.project;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//
//public class MenuButton extends JPanel {
//
//    private String text;
//    private int x;
//    private int y;
//
//    private int width;
//    private int height;
//
//    private boolean enabled;
//    private boolean clicked;
//    private ActionListener listener;
////    private int row;
////    private Gamestate state;
//    private Rectangle buttonBounds;
//
//    public MenuButton(ActionListener listener, String text, int x, int y, int width, int height) {
//        this.listener = listener;
//        this.text = text;
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        enabled = true;
//        initializeBounds();
//
//
//    }
//
//    private void initializeBounds() {
//        this.buttonBounds = new Rectangle(x, y, width, height);
//    }
//
//    public void render(Graphics g) {
//        if (clicked) {
//            g.setColor(Color.orange);
//        }
//        else {
//            g.setColor(Color.yellow);
//        }
//        if (enabled) {
//            g.fillRect(x, y, width, height);
//            g.setColor(Color.black);
//            int textWidth = g.getFontMetrics().stringWidth(text);
//            int textHeight = g.getFontMetrics().getHeight();
//            g.drawString(text, x + width / 2 - textWidth / 2, y + height / 2 + textHeight / 4);
//        }
//    }
//
//    private boolean isClicked(int x, int y) {
//        return x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height;
//    }
//
//    public void mousePressed(MouseEvent e) {
//        if (isClicked(e.getX(), e.getY())) {
//            clicked = true;
//        }
//    }
//
//    public void mouseReleased(MouseEvent e) {
//        if (clicked && enabled) {
//            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, text)); {
//                clicked = false;
//            }
//        }
//    }
//
//
//}
