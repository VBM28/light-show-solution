package org.example.service;

import org.example.data.Instruction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderService {

    public static List<Instruction> readFile(String filePath) {
        List<Instruction> instructionList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while (line != null) {
                try {
                    instructionList.add(processInstruction(line));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return instructionList;
    }

    private static Instruction processInstruction(String instruction) throws Exception {
        String[] instructions = instruction.split("\\W");
        switch (instructions.length) {
            case 7 -> {
                return createInstruction(instructions[1], instructions[2], instructions[3], instructions[5], instructions[6]);
            }
            case 6 -> {
                return createInstruction(instructions[0], instructions[1], instructions[2], instructions[4], instructions[5]);
            }
            default -> throw new Exception("Instruction cannot be processed: " + instruction);
        }
    }

    private static Instruction createInstruction(String command, String startX, String startY, String endX, String endY) throws Exception {
       try {
           return new Instruction(
                   command,
                   Integer.parseInt(startX),
                   Integer.parseInt(startY),
                   Integer.parseInt(endX),
                   Integer.parseInt(endY)
           );
       } catch (NumberFormatException e){
           throw new Exception("Error parsing the parameter from String to Integer. " + e.getMessage());
       }
    }
}
