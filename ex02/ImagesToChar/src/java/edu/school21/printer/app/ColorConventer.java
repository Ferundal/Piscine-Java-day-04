package edu.school21.printer.app;

import com.beust.jcommander.IStringConverter;

import java.awt.*;

public class ColorConventer implements IStringConverter<Color> {

    @Override
    public Color convert(String color) {
        switch (color) {
            case "WHITE":
                return Color.WHITE;
            case "BLACK":
                return Color.BLACK;
            case "BLUE":
                return Color.BLUE;
            case "CYAN":
                return Color.CYAN;
            case "DARK_GRAY":
                return Color.DARK_GRAY;
            case "GRAY":
                return Color.GRAY;
            case "GREEN":
                return Color.GREEN;
            case "LIGHT_GRAY":
                return Color.LIGHT_GRAY;
            case "MAGENTA":
                return Color.MAGENTA;
            case "RED":
                return Color.RED;
        }
        return null;
    }
}
