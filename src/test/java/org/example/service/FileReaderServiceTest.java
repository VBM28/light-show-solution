package org.example.service;

import org.example.data.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.service.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderServiceTest {

    @Test
    @DisplayName("readFile should return an empty list when the filePath is not valid")
    void readFileNoFile() {
        assertEquals(0, FileReaderService.readFile("asd").size());
    }

    @Test
    @DisplayName("readFile should return a list with 3 entries")
    void readFile3Entries() {
        assertEquals(3, FileReaderService.readFile(FILE_3_ENTRIES).size());
    }

    @Test
    @DisplayName("readFile should return a list with 3 commands in this order: on, off, toggle")
    void readFileCommandsOrder() {
        List<Instruction> instructionList = FileReaderService.readFile(FILE_3_ENTRIES);
        assertEquals("on", instructionList.get(0).getCommand());
        assertEquals("off", instructionList.get(1).getCommand());
        assertEquals("toggle", instructionList.get(2).getCommand());
    }

    @Test
    @DisplayName("readFile should only return a list with one instruction, the other 2 should only print exceptions to console")
    void readFileOneGoodEntry() {
        assertEquals(1, FileReaderService.readFile(FILE_3_ENTRIES_2_FAULTY).size());
    }

    @Test
    @DisplayName("readFile should return an empty list when the file is empty")
    void readFileEmptyFile() {
        assertEquals(0, FileReaderService.readFile(FILE_0_ENTRIES).size());
    }
}