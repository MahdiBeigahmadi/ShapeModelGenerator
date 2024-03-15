package ca.cmpt213.as4.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * TrivialShapeModel class
 * TrivialShapeModel.java
 *
 * Class Description:
 * Class Invariant:
 *
 * Author: Mahdi Beigahmadi
 * Student ID: 301570853
 * Last modified: March. 2024
 */

public class TrivialShapeModel implements ca.cmpt213.as4.ShapeModel {

    private final List<ShapeModel> pictures = new ArrayList<>();
    private int top, left, width, height;
    private String background, color, line, fill, fillText;
    private Color backgroundColor;
    private char lineChar;

    @Override
    public void populateFromJSON(File jsonFile) {
        try {
            JsonElement file = JsonParser.parseReader(new FileReader((jsonFile)));
            JsonObject fileObject = file.getAsJsonObject();
            JsonArray shapes = fileObject.get("shapes").getAsJsonArray();
            createObject(shapes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createObject(JsonArray shapes) {
        for (JsonElement shape : shapes) {
            drawShapeFeatures(shape);
            switch (background) {
                case "solid" -> {
                    if (fill.equals("wrapper")) {
                        pictures.add(new Wrapper(top, left, width, height, background,
                                backgroundColor, line, lineChar, fill, fillText));
                    } else if (line.equals("ascii line")) {
                        pictures.add(new AsciiCodeBorderStyle(top, left, width, height, background,
                                backgroundColor, line, lineChar, fill, fillText));
                    } else if (line.equals("sequence")) {
                        pictures.add(new Sequence(top, left, width, height, background,
                                backgroundColor, line, lineChar, fill, fillText));
                    } else {
                        pictures.add(new SolidShape(top, left, width, height, background,
                                backgroundColor, line, lineChar, fill, fillText) {
                        });
                    }
                }
                case "triangle" -> pictures.add(new Triangular(top, left, width, height, background,
                        backgroundColor, line, lineChar, fill, fillText));
                case "checker" -> pictures.add(new Checker(top, left, width, height, background,
                        backgroundColor, line, lineChar, fill, fillText));
            }
        }
    }

    public void drawShapeFeatures(JsonElement shape) {
        JsonObject shapeObject = shape.getAsJsonObject();
        convertInputs(shapeObject);
        if (color.equalsIgnoreCase("dark gray")) {
            backgroundColor = Color.DARK_GRAY;
        } else if (color.equalsIgnoreCase("light gray")) {
            backgroundColor = Color.LIGHT_GRAY;
        } else {
            try {
                backgroundColor = (Color) Color.class.getField(color).get(null);
            } catch (Exception e) {
                backgroundColor = null;
            }
        }
        line = shapeObject.get("line").getAsString();
        if (line.equals("char")) {
            lineChar = shapeObject.get("lineChar").getAsString().charAt(0);
        }
        fill = shapeObject.get("fill").getAsString();
        fillText = shapeObject.get("fillText").getAsString();
    }

    private void convertInputs(JsonObject shapeObject) {
        top = Integer.parseInt(shapeObject.get("top").getAsString());
        left = Integer.parseInt(shapeObject.get("left").getAsString());
        width = Integer.parseInt(shapeObject.get("width").getAsString());
        height = Integer.parseInt(shapeObject.get("height").getAsString());
        background = shapeObject.get("background").getAsString();
        color = shapeObject.get("backgroundColor").getAsString().toUpperCase();
    }

    @Override
    public void redact() {
        backgroundColor = Color.LIGHT_GRAY;
        for (ShapeModel shapes : pictures) {
            shapes.setBackgroundColor(backgroundColor);
            shapes.setRedacted(true);
            shapes.setLine("char");
            shapes.setLineChar('+');
            shapes.setFill("solid");
            shapes.setFillText("X");
        }
    }

    @Override
    public Iterator<ShapeModel> iterator() {
        return pictures.iterator();
    }
}
