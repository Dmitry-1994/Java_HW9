package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RadioTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/correctRadioStation.csv")
    public void setCurrentRadioStationTest(int set, int expected) {
        Radio radio = new Radio();
        radio.setNumberCurrentRadioStation(set);
        int actual = radio.getNumberCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextStationTest() {
        Radio radio = new Radio();
        for (int i = 1; i <= 10; i++) {
            radio.next();
            int actual = radio.getNumberCurrentRadioStation();
            if (i < 10) {
                Assertions.assertEquals(i, actual);
            } else Assertions.assertEquals(0, actual);

        }
    }

    @Test
    public void prevStationTest() {
        Radio radio = new Radio();
        for (int i = 9; i >= -1; i--) {
            radio.prev();
            int actual = radio.getNumberCurrentRadioStation();
            if (i >= 0) {
                Assertions.assertEquals(i, actual);
            } else Assertions.assertEquals(9, actual);

        }
    }

    @Test
    public void volumeIncreaseDecreaseTest() {
        Radio radio = new Radio();
        for (int i = 1; i <= 11; i++) {
            radio.increaseVolume();
            int actual = radio.getVolumeCurrent();
            if (i <= 10) {
                Assertions.assertEquals(i, actual);
            } else {
                Assertions.assertEquals(10, actual);
            }
        }
        for (int k = 9; k >= -1; k--) {
            radio.decreaseVolume();
            int actual = radio.getVolumeCurrent();
            if (k >= 0) {
                Assertions.assertEquals(k, actual);
            } else {
                Assertions.assertEquals(0, actual);
            }
        }
    }
}

