package ca.cmpt213.as4.model;

import java.awt.*;
/*
 * AsciiCodeBorderStyle class
 * AsciiCodeBorderStyle.java
 *
 * Class Description: it styles the border according to the ascii code shapes.
 * Class Invariant:
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: March. 2024
 */

public class AsciiCodeBorderStyle extends SolidShape {
    private static final char TOP_LEFT_CORNER = '╔';
    private static final char BOTTOM_LEFT_CORNER = '╚';
    private static final char TOP_RIGHT_CORNER = '╗';
    private static final char BOTTOM_RIGHT_CORNER = '╝';
    private static final char VERTICAL_LINE = '║';
    private static final char HORIZONTAL_LINE = '═';
    private static final char BLOCK = '■';

    public AsciiCodeBorderStyle(int top, int left, int width,
                                int height, String background, Color backgroundColor,
                                String line, char lineChar, String fill, String fillText) {
        super(top, left, width,
                height, background, backgroundColor,
                line, lineChar, fill, fillText);
    }

    @Override
    public char getBorderStyle(int xAxis, int yAxis) {
        if (getIsRedacted()) {
            return getLineChar();
        }

        if (getWidth() + getHeight() < 4) {
            return BLOCK;
        }

        boolean isTopEdge = yAxis == 0;
        boolean isBottomEdge = yAxis == getHeight() - 1;
        boolean isLeftEdge = xAxis == 0;
        boolean isRightEdge = xAxis == getWidth() - 1;

        if (isTopEdge) {
            if (isLeftEdge) return TOP_LEFT_CORNER;
            else if (isRightEdge) return TOP_RIGHT_CORNER;
            else return HORIZONTAL_LINE;
        } else if (isBottomEdge) {
            if (isLeftEdge) return BOTTOM_LEFT_CORNER;
            else if (isRightEdge) return BOTTOM_RIGHT_CORNER;
            else return HORIZONTAL_LINE;
        } else if (isLeftEdge || isRightEdge) {
            return VERTICAL_LINE;
        }
        return ' ';
    }

    @Override
    public boolean checkIfShapeContainsThisPart(int i, int j) {
        return false;
    }
}
