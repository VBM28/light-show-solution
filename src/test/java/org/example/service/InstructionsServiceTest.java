package org.example.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.service.utils.Constants.FILE_3_ENTRIES;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InstructionsServiceTest {

    @Test
    @DisplayName("calculateNoOfLights should return 0 when the version is not 1 or 2")
    void calculateNoOfLightsBadVersion() {
        assertEquals(0, InstructionsService.calculateNoOfLights(FILE_3_ENTRIES, 4));
    }

    @Test
    @DisplayName("calculateNoOfLights should return 0 when the version is not 1 or 2")
    void calculateNoOfLightsV1() {
        assertEquals(998004, InstructionsService.calculateNoOfLights(FILE_3_ENTRIES, 1));
    }

    @Test
    @DisplayName("calculateNoOfLights should return 0 when the version is not 1 or 2")
    void calculateNoOfLightsV2() {
        assertEquals(1003996, InstructionsService.calculateNoOfLights(FILE_3_ENTRIES, 2));
    }
}