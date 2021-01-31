package com.dstu.laba7.ux.figures;


import java.awt.*;

public abstract class FigureAbstract implements Figure{

    protected int sizeX;
    protected int sizeY;

    private int flag = 0;

    private final double maxSize;
    private final double minSize;

    protected Color color;

    public FigureAbstract(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.maxSize = sizeX * 1.38;
        this.minSize = sizeY * 0.5;
    }

    @Override
    public void reSize(double step) {

        if (flag == 0){
            sizeUp(step);
        }else {
            sizeDown(step);
        }

    }

    @Override
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private void sizeUp(double step){
        if(sizeX<maxSize){
            sizeX += step;
            sizeY += step;
        }else {
            flag = 1;
        }
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void reColor() {
        int r = (int) (Math.random() * 254);
        int g = (int) (Math.random() * 254);
        int b = (int) (Math.random() * 254);
        color = new Color(r,g,b);
    }

    private void sizeDown(double step){
        if(sizeX>minSize){
            sizeX -= step;
            sizeY -= step;
        } else{
            flag = 0;
        }
    }

    @Override
    public abstract Shape getShape();
}
