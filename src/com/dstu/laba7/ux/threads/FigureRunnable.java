package com.dstu.laba7.ux.threads;

import com.dstu.laba7.ux.figures.Figure;
import com.dstu.laba7.ux.panels.FigurePanel;

import java.awt.*;

public class FigureRunnable implements Runnable{

    private final Figure figure;
    private final Component component;
    private int step = 0;

    public FigureRunnable(Figure figure, Component component,int step) {
        this.figure = figure;
        this.component = component;
        this.step = step;
    }

    @Override
    public void run()
    {
        int flag = 0;
        System.out.println("Thread with "+figure.getClass().toString()+" is started");
        try
        {
            for (int i = 0; true; ) {
                if(figure.getClass().equals(FigurePanel.rectangle.getClass())){
                    if ((figure.getShape().getBounds().x > FigurePanel.round.getShape().getBounds().x-3)||(figure.getShape().getBounds().x > FigurePanel.round.getShape().getBounds().x+3)||
                            (figure.getShape().getBounds().x < FigurePanel.managedRectangle.getShape().getBounds().x-90)||(figure.getShape().getBounds().x < FigurePanel.managedRectangle.getShape().getBounds().x+90)){
                        flag=(figure.getFlag() == 1)?0:1;
                        figure.setFlag(flag);
                        figure.reColor();
                    }
                }else{
                    if ((figure.getShape().getBounds().x < FigurePanel.rectangle.getShape().getBounds().x-3)||(figure.getShape().getBounds().x < FigurePanel.rectangle.getShape().getBounds().x+3)||
                            (figure.getShape().getBounds().x < FigurePanel.managedRectangle.getShape().getBounds().x-3)||(figure.getShape().getBounds().x < FigurePanel.managedRectangle.getShape().getBounds().x+3)){
                        flag=(figure.getFlag() == 1)?0:1;
                        figure.setFlag(flag);
                        figure.reColor();
                    }
                }
                figure.reSize(step);
                component.repaint();
                int DELAY = 10;
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException ignored)
        {
        }
    }
}
