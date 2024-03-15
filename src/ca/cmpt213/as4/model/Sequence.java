package ca.cmpt213.as4.model;

import java.awt.*;
/*
 * Sequence class
 * Sequence.java
 *
 * Class Description: it creates borders based on the sequence of numbers
 * Class Invariant:
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: March. 2024
 */

public class Sequence extends SolidShape {

    private final Character[] numbers = {'1', '2', '3', '4', '5'};

    public Sequence(int top, int left, int width,
                    int height, String background, Color backgroundColor,
                    String line, char lineChar, String fill, String fillText) {
        super(top, left, width, height, background,
                backgroundColor, line, lineChar, fill, fillText);
    }

    @Override
    public char getBorderStyle(int i, int j) {
        if (getIsRedacted()) {
            return getLineChar();
        }

        int width = getWidth();
        int height = getHeight();
        int maxIndexSum = (width - 1) + (height - 1);

        if (j == 0) {
            return numbers[i % 5];
        } else if (i == width - 1) {
            return numbers[(i + j) % 5];
        } else if (j == height - 1) {
            return numbers[(maxIndexSum - i) % 5];
        } else if (i == 0) {
            return numbers[(maxIndexSum - j + width - 1) % 5];
        }
        return ' ';
    }
    @Override
    public boolean checkIfShapeContainsThisPart(int i, int j) {
        return false;
    }
}
