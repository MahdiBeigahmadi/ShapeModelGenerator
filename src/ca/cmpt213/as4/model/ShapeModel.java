package ca.cmpt213.as4.model;

import ca.cmpt213.as4.UI.DrawableShape;

import java.awt.*;
/*
 * ShapeModel class
 * ShapeModel.java
 *
 * Class Description: This is the main model shape
 * Class Invariant:
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: March. 2024
 */

public abstract class ShapeModel implements DrawableShape {
    private final int top, left, width, height;
    private final String background;
    private String fillText, line, fill;
    private Color backgroundColor;
    private char lineChar;
    private boolean isRedacted;

    ShapeModel(int top, int left, int width,
               int height, String background, Color backgroundColor,
               String line, char lineChar, String fill, String fillText) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
        this.background = background;
        this.backgroundColor = backgroundColor;
        this.line = line;
        this.lineChar = lineChar;
        this.fill = fill;
        this.fillText = fillText;
        this.isRedacted = false;
    }

    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getBackground() {
        return background;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public char getLineChar() {
        return lineChar;
    }

    public void setLineChar(char lineChar) {
        this.lineChar = lineChar;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getFillText() {
        return fillText;
    }

    public void setFillText(String fillText) {
        this.fillText = fillText;
    }

    public void setRedacted(boolean redacted) {
        isRedacted = redacted;
    }

    public boolean getIsRedacted() {
        return isRedacted;
    }

    public boolean isBorderCell(int topBorderCell, int leftBorderCell) {
        if (topBorderCell == 0 || topBorderCell == getWidth() - 1) {
            return true;
        } else return leftBorderCell == 0 || leftBorderCell == getHeight() - 1;
    }
}
