package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RadioTest {
    private int countRadioStation = 15;
    @ParameterizedTest
    @CsvFileSource(resources = "/correctRadioStation.csv")
    public void setCurrentRadioStationTest(int setCountRadioStation, int setNumberRadioStation, int expected) {
        Radio radio = new Radio(setCountRadioStation);
        radio.setNumberCurrentRadioStation(setNumberRadioStation);
        Assertions.assertEquals(expected, radio.getNumberCurrentRadioStation());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/correctRadioStationBase.csv")
    public void setCurrentRadioStationBase(int setNumberRadioStation, int expected) {
        Radio radio = new Radio();
        radio.setNumberCurrentRadioStation(setNumberRadioStation);
        Assertions.assertEquals(expected, radio.getNumberCurrentRadioStation());
    }

    @Test
    public void nextStationTest() {
        Radio radio = new Radio(countRadioStation);
        for (int i = 1; i <= countRadioStation; i++) {
            radio.next();
            int actual = radio.getNumberCurrentRadioStation();
            if (i < countRadioStation) {
                Assertions.assertEquals(i, actual);
            } else {
                Assertions.assertEquals(0, actual);
            }

        }
    }

    @Test
    public void prevStationTest() {
        Radio radio = new Radio(countRadioStation);
        for (int i = radio.getMaxNumberRadioStation(); i >= -1; i--) {
            radio.prev();
            int actual = radio.getNumberCurrentRadioStation();
            if (i >= 0) {
                Assertions.assertEquals(i, actual);
            } else {
                Assertions.assertEquals(radio.getMaxNumberRadioStation(), actual);
            }

        }
    }

    @Test
    public void volumeIncreaseDecreaseTest() {
        Radio radio = new Radio(countRadioStation);
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

