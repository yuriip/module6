package ua.goit.java.menu;

import ua.goit.java.controller.InputController;
import ua.goit.java.shop.Shop;

import java.io.IOException;

public class ViewOrder extends Menu {
    public ViewOrder(InputController ic) {
        super(ic);
    }

    @Override
    public void processMenu(Shop shop) throws IOException {
        System.out.println("Ваш заказ:");
        shop.listGoodsFromMap(shop.getOrders());
        System.out.print("--------------------------------------");
    }
}
