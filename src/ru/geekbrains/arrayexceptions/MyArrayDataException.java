package ru.geekbrains.arrayexceptions;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(String msg) {
        super(msg);
    }

    public MyArrayDataException(String msg, Throwable cause) {
        super(msg);
    }

}
