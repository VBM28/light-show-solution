package org.example.service.utils;

import java.io.File;

public class Constants {
    private static final String ABSOLUTE_PATH = new File("").getAbsolutePath();
    public static final String FILE_3_ENTRIES = ABSOLUTE_PATH + "/src/test/resources/input_3_entries.txt";
    public static final String FILE_3_ENTRIES_2_FAULTY = ABSOLUTE_PATH + "/src/test/resources/input_3_entries_2_bad.txt";
    public static final String FILE_0_ENTRIES = ABSOLUTE_PATH + "/src/test/resources/input_0_entries.txt";
}
