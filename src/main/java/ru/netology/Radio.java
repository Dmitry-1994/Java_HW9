package ru.netology;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Radio {
    private int countRadioStation;
    private int maxNumberRadioStation;
    private int numberCurrentRadioStation;
    private int volumeCurrent;

    public Radio(){
        setCountRadioStation(10);
        setMaxNumberRadioStation(countRadioStation - 1);
    }
    public Radio(int countRadioStation){
        if (countRadioStation > 0){
            setCountRadioStation(countRadioStation);
        } else {
            setCountRadioStation(10);
        }
        setMaxNumberRadioStation(getCountRadioStation() - 1);
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

    // Настройка громкости

    public void increaseVolume() {
        if (volumeCurrent < 10) {
            setVolumeCurrent(volumeCurrent + 1);
        } else {
            return;
        }
    }

    public void decreaseVolume() {
        if (volumeCurrent > 0) {
            setVolumeCurrent(volumeCurrent - 1);
        } else {
            return;
        }
    }
}
