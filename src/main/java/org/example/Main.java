package org.example;

import org.example.service.InstructionsService;

public class Main {
    public static void main(String[] args) {
        String filePath = System.getenv("filePath");
        Integer version = Integer.parseInt(System.getenv("version"));
        System.out.println(InstructionsService.calculateNoOfLights(filePath, version));
    }
}
