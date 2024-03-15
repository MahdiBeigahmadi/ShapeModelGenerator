package ca.cmpt213.as4.model;

import java.awt.*;
/*
 * Checker class
 * Checker.java
 *
 * Class Description: it fills each cell one by one to create chess shaped board
 * Class Invariant:
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: March. 2024
 */

public class Checker extends SolidShape {
    public Checker(int top, int left, int width,
                   int height, String background, Color backgroundColor,
                   String line, char lineChar, String fill, String fillText) {
        super(top, left, width, height, background,
                backgroundColor, line, lineChar, fill, fillText);
    }

    /**
     * Determines if a given point (i, j) is part of the checkerboard pattern.
     *
     * @param i The row position of the point.
     * @param j The column position of the point.
     * @return true if the point is part of the pattern, false otherwise.
     */
    @Override
    public boolean checkIfShapeContainsThisPart(int i, int j) {
        return (i % 2 == 0) == (j % 2 == 0);
    }
}
