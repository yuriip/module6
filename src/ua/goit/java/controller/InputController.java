package ua.goit.java.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputController {
    private BufferedReader bufferedReader;

    public InputController(InputStream in) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(in));
    }

    public int readInt() throws IOException {
        int res;
        while (true) {
            try {
                String str1 = bufferedReader.readLine();
                res = Integer.parseInt(str1);
                break;
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("!!! Ошибка. Необходимо ввести число. Попробуйте еще раз !!!");
            }
        }

        return res;
    }

    public String readString() throws IOException {
        return bufferedReader.readLine();
    }
}
