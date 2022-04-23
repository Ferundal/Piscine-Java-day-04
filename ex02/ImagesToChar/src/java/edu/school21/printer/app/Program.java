package edu.school21.printer.app;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameters;
import com.sun.tools.javac.Main;
import edu.school21.printer.logic.Painter;
import edu.school21.printer.logic.WrongImageFileFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;


@Parameters(separators = "=")
public class Program {
    @Parameter(names = "--white", converter = ColorConventer.class)
    public Color white;
    @Parameter(names = "--black", converter = ColorConventer.class)
    public Color black;
    private static String PATH_TO_IMAGE_JAR_ARCHIVE = "/resources/it.bmp";
    public static void main(String [] argv) {
        Program program = new Program();
        JCommander.newBuilder()
                .addObject(program)
                .build()
                .parse(argv);
        program.run();

    }
    private void run() {
        BufferedImage bufferedImage = null;
        try {
            if (this.black == null || this.white == null) {
                throw new WrongCommandLineArguments();
            }
            try {
                bufferedImage = ImageIO.read(Program.class.getResource(PATH_TO_IMAGE_JAR_ARCHIVE));
            } catch (IOException ioException) {
                throw new RuntimeException();
            }
        } catch (WrongCommandLineArguments wrongCommandLineArguments) {
            System.err.println(wrongCommandLineArguments.toString());
            System.exit(-1);
        }
        try {
            new Painter(bufferedImage, this.white, this.black).paint();
        } catch (WrongImageFileFormat wrongImageFileFormat) {
            System.err.println(wrongImageFileFormat.toString());
        }
    }
}
