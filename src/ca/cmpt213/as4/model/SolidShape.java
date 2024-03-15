package ca.cmpt213.as4.model;

import ca.cmpt213.as4.UI.Canvas;

import java.awt.*;
/*
 * SolidShape class
 * SolidShape.java
 *
 * Class Description: prints the solid background
 * Class Invariant:
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: March. 2024
 */

public class SolidShape extends ShapeModel {

    public SolidShape(int top, int left, int width, int height,
                      String background, Color backgroundColor, String line,
                      char lineChar, String fill, String fillText) {
        super(top, left, width, height, background,
                backgroundColor, line, lineChar, fill, fillText);
    }

    @Override
    public void draw(Canvas canvas) {
        for (int j = 0; j < getHeight(); j++) {
            for (int i = 0; i < getWidth(); i++) {
                drawOnCanvasBasedOnXandY(canvas, i, j);
            }
        }
    }

    private void drawOnCanvasBasedOnXandY(Canvas canvas, int i, int j) {
        int xAxisLocationOnCanvas = getLeft() + i;
        int yAxisLocationOnCanvas = getTop() + j;
        if (isBorderCell(i, j)) {
            canvas.setCellText(xAxisLocationOnCanvas, yAxisLocationOnCanvas, getBorderStyle(i, j));
        } else {
            canvas.setCellText(xAxisLocationOnCanvas, yAxisLocationOnCanvas, getCellText());
        }
        if (checkIfShapeContainsThisPart(i, j) || getIsRedacted()) {
            canvas.setCellColor(xAxisLocationOnCanvas, yAxisLocationOnCanvas, getBackgroundColor());
        }
    }

    public char getBorderStyle(int i, int j) {
        return getLineChar();
    }

    public char getCellText() {
        return getFillText().charAt(0);
    }

    /**
     * Determines if a given point (i, j) is part of the checkerboard pattern.
     *
     * @param i The row position of the point.
     * @param j The column position of the point.
     * @return true if the point is part of the pattern, false otherwise.
     */
    public boolean checkIfShapeContainsThisPart(int i, int j) {
        return true;
    }
}
