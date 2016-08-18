package ua.goit.java.menu;

import ua.goit.java.controller.InputController;
import ua.goit.java.shop.Shop;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Menu {
    private InputController ic;
    protected ArrayList<Menu> menus;

    public Menu(InputController ic) {
        this.ic = ic;
        menus = new ArrayList<>();
    }

    public InputController getIc() {
        return ic;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public abstract void processMenu(Shop shop) throws IOException;
}
