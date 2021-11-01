package by.epam.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Scanner;

public class MethodsForFile {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodsForFile.class);

    public static String parseFile(String path) {
        String content = "";

        try {
            content = new Scanner(new File(path)).useDelimiter("\\Z").next();
            LOGGER.info(" the file has been read.");

        } catch (Exception e) {
            LOGGER.error("the file was not read. ERROR: " + e.toString());
        }

        return content;
    }
}
