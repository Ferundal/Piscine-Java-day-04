package edu.school21.printer.logic;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Painter {
    BufferedImage bufferedImage;
    Color white;
    Color black;
    private Painter() {}
    public Painter(BufferedImage bufferedImage, Color white, Color black) {
        this.bufferedImage = bufferedImage;
        this.white = white;
        this.black = black;
    }
    public void paint() throws WrongImageFileFormat {
        for (int y = 0; y < bufferedImage.getHeight(); ++y) {
            for (int x = 0; x < bufferedImage.getWidth(); ++x) {
                if (bufferedImage.getRGB(x, y) == Color.BLACK.getRGB()) {
                    System.out.print(Ansi.colorize(" ", Attribute.BACK_COLOR(black.getRed(), black.getGreen(), black.getBlue())));
                } else if (bufferedImage.getRGB(x, y) == Color.WHITE.getRGB()){
                    System.out.print(Ansi.colorize(" ", Attribute.BACK_COLOR(white.getRed(), white.getGreen(), white.getBlue())));
                } else {
                    throw new WrongImageFileFormat();
                }
            }
            System.out.print("\n");
        }
    }
}
