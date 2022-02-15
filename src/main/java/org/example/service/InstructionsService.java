package org.example.service;

import org.example.data.Instruction;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class InstructionsService {

    public static Integer calculateNoOfLights(String filePath, Integer version) {
        List<Instruction> instructions = FileReaderService.readFile(filePath);
        return switch (version) {
            case 1 -> processInstructions(instructions);
            case 2 -> processInstructionsV2(instructions);
            default -> 0;
        };
    }

    private static Integer processInstructionsV2(List<Instruction> instructions) {
        HashMap<String, Integer> lights = new HashMap<>();
        for (Instruction instruction : instructions) {
            for (int i = instruction.getStartX(); i <= instruction.getEndX(); i++) {
                for (int j = instruction.getStartY(); j <= instruction.getEndY(); j++) {
                    String position = i + "-" + j;
                    switch (instruction.getCommand().toLowerCase(Locale.ROOT)) {
                        case "on" -> updateLightStatus(position, lights, 1, 1);
                        case "off" -> updateLightStatus(position, lights, -1, 0);
                        case "toggle" -> updateLightStatus(position, lights, 2, 2);
                    }
                }
            }
        }
        return lights.values()
                .stream()
                .filter(it -> it > 0)
                .reduce(0, Integer::sum);
    }

    private static void updateLightStatus(String position, HashMap<String, Integer> lights, Integer updateEntry, Integer createEntry) {
        if (lights.containsKey(position)) {
            lights.put(position, lights.get(position) + updateEntry);
        } else {
            lights.put(position, createEntry);
        }
    }

    private static Integer processInstructions(List<Instruction> instructions) {
        HashMap<String, Boolean> lights = new HashMap<>();
        for (Instruction instruction : instructions) {
            for (int i = instruction.getStartX(); i <= instruction.getEndX(); i++) {
                for (int j = instruction.getStartY(); j <= instruction.getEndY(); j++) {
                    String position = i + "-" + j;
                    switch (instruction.getCommand().toLowerCase(Locale.ROOT)) {
                        case "on":
                            lights.put(position, true);
                            break;
                        case "off":
                            lights.put(position, false);
                            break;
                        case "toggle":
                            if (lights.containsKey(position)) {
                                lights.put(position, !lights.get(position));
                            } else lights.put(position, true);
                            break;
                    }
                }
            }
        }
        return Math.toIntExact(
                lights.values().stream().
                        filter(lightIsOn -> lightIsOn)
                        .count()
        );
    }


}
