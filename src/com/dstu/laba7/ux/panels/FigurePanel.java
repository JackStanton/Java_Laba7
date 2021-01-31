package com.dstu.laba7.ux.panels;

import com.dstu.laba7.ux.DisplayWorker;
import com.dstu.laba7.ux.figures.CustomRectangle;
import com.dstu.laba7.ux.figures.Figure;
import com.dstu.laba7.ux.figures.CustomRound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FigurePanel extends JPanel implements ActionListener {

    private final DisplayWorker displayWorker = new DisplayWorker();
    private final int WINDOW_CENTER_POS_X = displayWorker.getWindowCenter().get("POS_X");
    private final int WINDOW_CENTER_POS_Y = displayWorker.getWindowCenter().get("POS_Y");

    private final int x = 400;
    private final int y = 400;
    private final Figure rectangle = new CustomRectangle(x,y);
    private final Figure round = new CustomRound(x);


    private static int flag = 0;

    public FigurePanel() {
        Timer timer = new Timer(25, this);
        timer.start();

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.rotate(Math.toRadians(45),WINDOW_CENTER_POS_X,WINDOW_CENTER_POS_Y);

        rectangle.reSize(1);
        round.reSize(2);
        g2d.draw(round.getShape());

        g2d.draw(rectangle.getShape());
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}