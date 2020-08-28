package ru.geekbrains.arrayexceptions;

import java.util.Random;

public class ArraysCreator {
    String[][] strArr;

    public ArraysCreator(String[][] strArr) throws MyArrayDataException {

        this.strArr = strArr;
        int sum = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (checkErrorArraySize()) {
                for (int j = 0; j < strArr[i].length; j++) {
                    char[] c = doStrGen().toCharArray();
                    for (int k = 0; k < doStrGen().toCharArray().length; k++) {
                        strArr[i][j] = String.valueOf(c[k]);
                    }
                    System.out.print(strArr[i][j]);
                    try {
                        sum += Integer.parseInt(strArr[i][j]);
                    } catch (NumberFormatException e) {
                        System.out.println();
                        throw new MyArrayDataException("Некорректное значение " +
                                strArr[i][j] + " в позиции " + i + "x" + j + " ", e);

                    }
                }
                System.out.println();
            }
        }
        System.out.println("Сумма элеменов равна: " + sum);

    }

    private String doStrGen() {
        char[] chars = "0123456789a".toCharArray();
        StringBuilder sb = new StringBuilder(16);
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();

    }

    private boolean checkErrorArraySize() throws MyArraySizeException {
        if (strArr.length == 4) {
            for (int i = 0; i <= strArr.length - 1; i++) {
                if (strArr[i].length != 4) {
                    System.out.println(strArr.length + " X " + strArr[strArr.length - 1].length);
                    throw new MyArraySizeException("Недопустимый размер массива");
                }
              }
        } else {
            System.out.println(strArr.length + " X " + strArr[strArr.length - 1].length);
            throw new MyArraySizeException("Недопустимый размер массива");
        }
        return true;
    }

}
