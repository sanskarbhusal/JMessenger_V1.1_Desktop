package client.component;

import java.awt.Color;

/**
 *
 * @author Sanskar
 */
public class Theme {

    private static Color THEME_COLOR;

    //The below method is supposed to be invoked by the components that need 
    //to set color as that of Item_People object
    public static Color getTheme() {
        return THEME_COLOR;
    }
//Item_People class will invoke the below method to set the theme color(as of now) 

    public static void setTheme(Color c) {
        THEME_COLOR = c;//c is the color that is passed by the Item_People class's object.
    }
}
