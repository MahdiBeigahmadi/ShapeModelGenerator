package ca.cmpt213.as4.model;

import java.awt.*;
import java.util.*;
import java.util.List;
/*
 * Wrapper class
 * Wrapper.java
 *
 * Class Description: the wrapped text inside the shapes
 * Class Invariant:
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: March. 2024
 */
public class Wrapper extends SolidShape {

    private final String text = getFillText();
    private String shapedSentences = "";
    private int counter = 0;

    public Wrapper(int top, int left, int width,
                   int height, String background, Color backgroundColor,
                   String line, char lineChar, String fill, String fillText) {
        super(top, left, width, height, background, backgroundColor, line, lineChar, fill, fillText);
    }

    @Override
    public char getCellText() {
        if (getIsRedacted()) {
            return getFillText().charAt(0);
        }
        if (shapedSentences.isEmpty()) {
            arrangeFilledText();
        }
        char letter = (counter < shapedSentences.length()) ? shapedSentences.charAt(counter) : ' ';
        counter = (counter < shapedSentences.length()) ? counter + 1 : counter;
        return letter;
    }

    public void arrangeFilledText() {
        String[] wordsOfText = text.split(" ");
        List<String> textLine = new ArrayList<>();
        int lineWidth = getWidth() - 2;
        StringBuilder tempLine = new StringBuilder();

        for (String word : wordsOfText) {
            int lineLength = tempLine.length();
            int wordLength = word.length();

            if (wordLength > lineWidth) {
                while (wordLength > 0) {
                    int chunkLength = Math.min(wordLength, lineWidth);
                    textLine.add(word.substring(0, chunkLength));
                    word = word.substring(chunkLength);
                    wordLength = word.length();
                }
            } else {
                if (lineLength > 0 && lineLength + wordLength + 1 <= lineWidth) {
                    tempLine.append(" ").append(word);
                } else {
                    if (lineLength > 0) {
                        textLine.add(tempLine.toString());
                        tempLine = new StringBuilder();
                    }
                    tempLine.append(word);
                }
            }
        }

        if (!tempLine.isEmpty()) {
            textLine.add(tempLine.toString());
        }
        StringBuilder builder = new StringBuilder();
        for (String line : textLine) {
            builder.append(formatSpacing(lineWidth, line));
        }
        shapedSentences = builder.toString();
    }

    public String formatSpacing(int lineWidth, String line) {
        int spacesInLines = lineWidth - line.length();
        StringBuilder leftMargins = new StringBuilder();
        StringBuilder rightMargins = new StringBuilder();
        for (int j = 0; j < spacesInLines; j++) {
            if (j % 2 == 0) {
                leftMargins.append(" ");
            } else {
                rightMargins.append(" ");
            }
        }
        line = leftMargins + line + rightMargins;
        return line;
    }
}
