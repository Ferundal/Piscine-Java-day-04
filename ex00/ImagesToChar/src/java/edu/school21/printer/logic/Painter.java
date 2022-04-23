package edu.school21.printer.logic;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Painter {
    BufferedImage bufferedImage;
    char white;
    char black;
    private Painter() {}
    public Painter(BufferedImage bufferedImage, char white, char black) {
        this.bufferedImage = bufferedImage;
        this.white = white;
        this.black = black;
    }
    public void paint() throws WrongImageFileFormat {
        for (int y = 0; y < bufferedImage.getHeight(); ++y) {
            for (int x = 0; x < bufferedImage.getWidth(); ++x) {
                if (bufferedImage.getRGB(x, y) == Color.BLACK.getRGB()) {
                    System.out.print(black);
                } else if (bufferedImage.getRGB(x, y) == Color.WHITE.getRGB()){
                    System.out.print(white);
                } else {
                    throw new WrongImageFileFormat();
                }
            }
            System.out.print("\n");
        }
    }
}
