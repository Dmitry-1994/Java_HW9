package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RadioTest {
    private int countRadioStation = 15;
    private int maxNumberRadioStation = countRadioStation - 1;

    @ParameterizedTest
    @CsvFileSource(resources = "/correctRadioStation.csv")
    public void setCurrentRadioStationTest(int setupNumberRadioStation, int expected) {
        Radio radio = new Radio(countRadioStation);
        radio.setNumberCurrentRadioStation(setupNumberRadioStation);
        Assertions.assertEquals(expected, radio.getNumberCurrentRadioStation());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/countRadioStation.csv")
    public  void setInvalidCountRadioStation(int cntRadioStation, int expected){
        Radio radio = new Radio(cntRadioStation);
        Assertions.assertEquals(expected, radio.getCountRadioStation());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/maxRadioStation.csv")
    public void setMaxNumberRadioStation(int cntRadioStation, int expected){
        Radio radio = new Radio(cntRadioStation);
        Assertions.assertEquals(expected, radio.getMaxNumberRadioStation());
    }
    @Test
    public void nextStationTest() {
        Radio radio = new Radio(countRadioStation);
        for (int i = 1; i <= (maxNumberRadioStation + 1); i++) {
            radio.next();
            int actual = radio.getNumberCurrentRadioStation();
            if (i <= maxNumberRadioStation) {
                Assertions.assertEquals(i, actual);
            } else {
                Assertions.assertEquals(0, actual);
            }
        }
    }

    @Test
    public void prevStationTest() {
        Radio radio = new Radio(countRadioStation);
        for (int i = maxNumberRadioStation; i >= -1; i--) {
            radio.prev();
            int actual = radio.getNumberCurrentRadioStation();
            if (i >= 0) {
                Assertions.assertEquals(i, actual);
            } else {
                Assertions.assertEquals(maxNumberRadioStation, actual);
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

