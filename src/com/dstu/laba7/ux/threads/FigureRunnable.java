package com.dstu.laba7.ux.threads;

import com.dstu.laba7.ux.figures.Figure;

import java.awt.*;

public class FigureRunnable implements Runnable{

    private Figure figure;
    private Component component;
    private final int DELAY = 3;
    private int step = 0;

    public FigureRunnable(Figure figure, Component component,int step) {
        this.figure = figure;
        this.component = component;
        this.step = step;
    }

    @Override
    public void run()
    {
        System.out.println("Thread with "+figure.getClass().toString()+" is started");
        try
        {
            for (int i = 0; i == 0; i = 0) {
                figure.reSize(step);
                component.repaint();
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException ignored)
        {
        }
    }
}
