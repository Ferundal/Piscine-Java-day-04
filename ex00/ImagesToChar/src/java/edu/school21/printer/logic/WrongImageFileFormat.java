package edu.school21.printer.logic;

public class WrongImageFileFormat extends Throwable {
    @Override
    public String toString() {
        return "Unexpected colors in BMP file";
    }
}
