package ru.netology;

public class Radio {
    private int countRadioStation;
    private int maxNumberRadioStation;
    private int numberCurrentRadioStation;
    private int volumeCurrent;

    public Radio(){
        this.countRadioStation = 10;
        this.maxNumberRadioStation = countRadioStation - 1;
    }
    public Radio(int countRadioStation){
        if (countRadioStation > 0){
            this.countRadioStation = countRadioStation;
        } else {
            this.countRadioStation = 10;
        }
        this.maxNumberRadioStation = this.countRadioStation - 1;
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

    public void setNumberCurrentRadioStation(int newNumberRadioStation) {
        if ((newNumberRadioStation > maxNumberRadioStation) | (newNumberRadioStation < 0)) {
            return;
        } else {
            numberCurrentRadioStation = newNumberRadioStation;
        }
    }

    public int getNumberCurrentRadioStation() {
        return numberCurrentRadioStation;
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
