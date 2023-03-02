package ru.netology;

public class Radio {
    private int numberCurrentRadioStation;
    private int volumeCurrent;
    private int countRadioStation = 10;
    private int maxNumberRadioStation = countRadioStation - 1;
    public Radio(int countRadioStation){
        if (countRadioStation <= 0){
            return;
        }
        this.countRadioStation = countRadioStation;
        this.maxNumberRadioStation = countRadioStation - 1;
    }

    // Настройка радиостанций

    public void next() {
        if (numberCurrentRadioStation == maxNumberRadioStation) {
            numberCurrentRadioStation = 0;
        } else {
            numberCurrentRadioStation = numberCurrentRadioStation + 1;
        }
    }

    public void prev() {
        if (numberCurrentRadioStation == 0) {
            numberCurrentRadioStation = maxNumberRadioStation;
        } else {
            numberCurrentRadioStation = numberCurrentRadioStation - 1;
        }

    }

    public int getNumberCurrentRadioStation() {
        return numberCurrentRadioStation;
    }

    public void setNumberCurrentRadioStation(int newNumberRadioStation) {
        if ((newNumberRadioStation > maxNumberRadioStation) | (newNumberRadioStation < 0)) {
            return;
        } else {
            numberCurrentRadioStation = newNumberRadioStation;
        }
    }

    // Настройка громкости

    public void increaseVolume() {
        if (volumeCurrent < 10) {
            volumeCurrent = volumeCurrent + 1;
        } else {
            return;
        }
    }

    public void decreaseVolume() {
        if (volumeCurrent > 0) {
            volumeCurrent = volumeCurrent - 1;
        } else {
            return;
        }
    }

    public int getVolumeCurrent() {
        return volumeCurrent;
    }
}
