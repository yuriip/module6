package ua.goit.java;

import ua.goit.java.controller.InputController;
import ua.goit.java.menu.MainMenu;
import ua.goit.java.shop.MusicalShop;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        MusicalShop shop = new MusicalShop("Все для музыки");
        MainMenu menu = new MainMenu(new InputController(System.in));
        try {
            menu.processMenu(shop);
        } catch (IOException e) {
            System.out.println("!!! Глобальная ошибка ввода данных. Попробуйте перезапустить программу !!!");
        }
    }
}
