package ua.goit.java.menu;

import ua.goit.java.controller.InputController;
import ua.goit.java.goods.Goods;
import ua.goit.java.shop.Shop;

import java.io.IOException;
import java.util.List;

public class ViewOrder extends Menu {
    public ViewOrder(InputController ic) {
        super(ic);
    }

    @Override
    public void processMenu(Shop shop) throws IOException {
        System.out.println("Ваш заказ:");
        List<Goods> goods = shop.prepareGoods(shop.getOrders());
        if (goods != null) {
            if (!goods.isEmpty()) {
                for (Goods g :
                        goods) {
                    System.out.println(g);
                }
            } else {
                System.out.println("в заказе нет музыкальных инструментов");
            }
        }
        System.out.print("--------------------------------------");
    }
}
