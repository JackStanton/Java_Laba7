package com.dstu.laba7.ux.figures;


import java.awt.*;

public abstract class FigureAbstract implements Figure{

    protected double sizeX;
    protected double sizeY;

    private int flag = 0;

    private final double maxSize;
    private final double minSize;

    public FigureAbstract(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.maxSize = sizeX * 1.38;
        this.minSize = sizeY * 0.70;
    }

    @Override
    public void reSize(double step) {
        if (flag == 0){
            if(sizeX<maxSize){
                sizeX += step;
                sizeY += step;
            } else flag = 1;
        }
        if (flag == 1){
            if(sizeX>minSize){
                sizeX -= step;
                sizeY -= step;
            } else flag = 0;
        }
    }

    @Override
    public abstract Shape getShape();
}
