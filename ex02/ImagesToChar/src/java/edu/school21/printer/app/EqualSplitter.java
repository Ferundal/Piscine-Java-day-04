package edu.school21.printer.app;

import com.beust.jcommander.converters.IParameterSplitter;

import java.util.Arrays;
import java.util.List;

public class EqualSplitter implements IParameterSplitter {
    @Override
    public List<String> split(String string) {
        int stringFirstEqual = string.indexOf("=");
        if (stringFirstEqual == -1) {
            return Arrays.asList(string);
        } else if (string.length() <= stringFirstEqual + 1) {
            return Arrays.asList(string.substring(0, stringFirstEqual));
        }
        return Arrays.asList(string.substring(0, stringFirstEqual),
                string.substring(stringFirstEqual + 1, string.length()));
    }
}
