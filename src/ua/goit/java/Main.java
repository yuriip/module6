package ua.goit.java;

import ua.goit.java.controller.InputController;
import ua.goit.java.menu.MainMenu;
import ua.goit.java.shop.MusicalShop;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
//        String[] typesGoods = new String[]{"guitar", "piano", "trumpet"};
        MusicalShop shop = new MusicalShop("Все для музыки");
        MainMenu menu = new MainMenu(new InputController());
        try {
            menu.processMenu(shop);
        } catch (IOException e) {
            System.out.println("!!! Глобальная ошибка ввода данных. Попробуйте перезапустить программу !!!");
        } finally {
            try {
                new BufferedReader(new InputStreamReader(System.in)).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

