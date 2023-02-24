package ru.netology;
public class Radio {
    private int numberCurrentRadioStation;
    private int volumeCurrent;
    public void next(){
        if (numberCurrentRadioStation == 9){
            numberCurrentRadioStation = 0;
        }else numberCurrentRadioStation = numberCurrentRadioStation + 1;
    }
    public void prev(){
        if (numberCurrentRadioStation == 0){
            numberCurrentRadioStation = 9;
        }else numberCurrentRadioStation = numberCurrentRadioStation - 1;

    }
    public void setNumberCurrentRadioStation(int newNumberRadioStation){
        if ((newNumberRadioStation > 9) | (newNumberRadioStation < 0)){
            return;
        }else numberCurrentRadioStation = newNumberRadioStation;
    }
    public int getNumberCurrentRadioStation(){
        return numberCurrentRadioStation;
    }
    public void increaseVolume(){
        if (volumeCurrent < 10){
            volumeCurrent = volumeCurrent + 1;
        }else return;
    }
    public void decreaseVolume(){
        if (volumeCurrent > 0){
            volumeCurrent = volumeCurrent - 1;
        }else return;
    }
    public int getVolumeCurrent(){
        return volumeCurrent;
    }
}
