package edu.school21.printer.app;

public class WrongCommandLineArguments extends Throwable {
    @Override
    public String toString() {
        return "Wrong command line arguments";
    }
}
