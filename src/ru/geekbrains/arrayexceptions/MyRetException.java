package ru.geekbrains.arrayexceptions;

import java.util.Random;

public class MyRetException {
    public static void main(String[] args) {
        int row = new Random().nextInt(5) + 1; // должно быть = 4
        int col = new Random().nextInt(5) + 1; // и здесь
        String[][] arrays = new String[row][col];
        try {
            new ArraysCreator(arrays);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

}
