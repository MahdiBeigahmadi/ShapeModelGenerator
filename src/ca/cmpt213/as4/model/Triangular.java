package ca.cmpt213.as4.model;

import java.awt.*;
/*
 * Triangular class
 * Triangular.java
 *
 * Class Description: it designs triangular shape
 * Class Invariant:
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: March. 2024
 */
public class Triangular extends SolidShape {

    public Triangular(int top, int left, int width,
                      int height, String background, Color backgroundColor,
                      String line, char lineChar, String fill, String fillText) {
        super(top, left, width, height, background, backgroundColor, line, lineChar, fill, fillText);
    }

    @Override
    public boolean checkIfShapeContainsThisPart(int i, int j){
        return i >= j;
    }
}
