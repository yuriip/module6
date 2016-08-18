package ua.goit.java.menu;

import ua.goit.java.controller.InputController;
import ua.goit.java.shop.Shop;

import java.io.IOException;

public class CatalogInstrumentMenu extends Menu {
    public CatalogInstrumentMenu(InputController ic) {
        super(ic);
    }

    @Override
    public void processMenu(Shop shop) throws IOException {
        System.out.println("Каталог инструментов, которые есть в наличии:");
        shop.listGoodsFromMap(shop.getGoods());
        System.out.print("--------------------------------------");
    }
}
