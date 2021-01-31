package com.dstu.laba7.ux;


import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private static final DisplayWorker displayWorker = new DisplayWorker();
    private static final int WINDOW_HEIGHT = displayWorker.getHeight();
    private static final int WINDOW_WIDTH = displayWorker.getWidth();
    private static final int WINDOW_POSITION_X = displayWorker.getXPos();
    private static final int WINDOW_POSITION_Y = displayWorker.getYPos();
//    private static final int WINDOW_CENTER_POS_X = displayWorker.getWindowCenter().get("POS_X");
//    private static final int WINDOW_CENTER_POS_Y = displayWorker.getWindowCenter().get("POS_Y");


    public MainWindow() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(WINDOW_POSITION_X,WINDOW_POSITION_Y);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setResizable(false);
        setTitle("Lab 7");
        JPanel grid = new JPanel( new GridLayout(1,2) );
        JPanel panel = new Frame(300,300,1);
        add(panel);
        add(grid, BorderLayout.SOUTH);
        setVisible(true);
    }

}
