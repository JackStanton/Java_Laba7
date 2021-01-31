package com.dstu.laba7.ux;


import com.dstu.laba7.ux.panels.FigurePanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private static final DisplayWorker displayWorker = new DisplayWorker();
    private static final int WINDOW_HEIGHT = displayWorker.getHeight();
    private static final int WINDOW_WIDTH = displayWorker.getWidth();
    private static final int WINDOW_POSITION_X = displayWorker.getXPos();
    private static final int WINDOW_POSITION_Y = displayWorker.getYPos();


    public MainWindow() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(WINDOW_POSITION_X,WINDOW_POSITION_Y);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setResizable(false);
        setTitle("Lab 7");
        JPanel grid = new JPanel( new GridLayout(1,2) );
        JPanel panel = new FigurePanel();
        add(panel);
        add(grid, BorderLayout.SOUTH);
        setVisible(true);
    }
}
