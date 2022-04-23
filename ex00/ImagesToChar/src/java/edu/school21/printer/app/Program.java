package edu.school21.printer.app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import edu.school21.printer.logic.Painter;
import edu.school21.printer.logic.WrongImageFileFormat;
import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(String [] args) {
        BufferedImage bufferedImage = null;
        try {
            if (args.length != 3 || args[1].length() != 1 || args[2].length() != 1) {
                throw new WrongCommandLineArguments();
            }
            try {
                bufferedImage = ImageIO.read(new File(args[0]));
            } catch (IOException ioException) {
                throw new WrongCommandLineArguments();
            }
        } catch (WrongCommandLineArguments wrongCommandLineArguments) {
            System.err.println(wrongCommandLineArguments.toString());
            System.exit(-1);
        }
        try {
            new Painter(bufferedImage, args[1].toCharArray()[0], args[2].toCharArray()[0]).paint();
        } catch (WrongImageFileFormat wrongImageFileFormat) {
            System.err.println(wrongImageFileFormat.toString());
        }
    }
}
