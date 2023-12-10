package com.dt181g.project;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class View extends JFrame {


    private GamePanel gamePanel;


    public View() {
        setTitle("Flappy Bird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);


        gamePanel = new GamePanel();



        setVisible(true);

    }





    public void repaint() {
        gamePanel.repaint();
    }


}
