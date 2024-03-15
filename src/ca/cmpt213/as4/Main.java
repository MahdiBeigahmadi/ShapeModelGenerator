/**
 * Application to display the "picture" to the UI.
 */

package ca.cmpt213.as4;

import ca.cmpt213.as4.UI.GUI;
import ca.cmpt213.as4.model.TrivialShapeModel;


public class Main {
    public static void main(String[] args) {
        // Instantiate ShapeModel.java
        ShapeModel model = new TrivialShapeModel();

        // Instantiate GUI (with DI)
        GUI gui = new GUI(model);

        // Run GUI application
        gui.start();
    }
}
