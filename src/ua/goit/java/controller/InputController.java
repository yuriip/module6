package ua.goit.java.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int inputDataInt() throws IOException {
        int res;
        while (true) {
            try {
                String str1 = InputController.br.readLine();
                res = Integer.parseInt(str1);
                break;
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("!!! Ошибка. Необходимо ввести число. Попробуйте еще раз !!!");
            }
        }

        return res;
    }
}
