package com.crud.Controller;

public class InputError extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String message;
    InputError(String str) {
        message = str;
    }
    public String toString() {
        return ("Number Exception Occurred : " + message);
    }
}
