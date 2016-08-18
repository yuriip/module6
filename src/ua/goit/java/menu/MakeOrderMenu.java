package ua.goit.java.menu;

import ua.goit.java.controller.InputController;
import ua.goit.java.enums.TypesGoods;
import ua.goit.java.exception.InvalidKeyException;
import ua.goit.java.shop.Shop;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MakeOrderMenu extends Menu {
    public MakeOrderMenu(InputController ic) {
        super(ic);
    }

    @Override
    public void processMenu(Shop shop) throws IOException {
        Map<String, Integer> order = new HashMap<>();
        System.out.println("Для поставки музыкальных инструментов необходимо создать заказ");
        System.out.println("В наличии есть следующие музыкальные инструменты:");
        shop.listGoodsFromMap(shop.getGoods());

        while (true) {
            StringBuilder str = new StringBuilder("(допустимые назвния ");
            for (TypesGoods type : TypesGoods.values()) {
                str.append(type.toString().toLowerCase() + ", ");
            }
            str.setLength(str.length() - 2);
            str.append(")");

            System.out.println("Для добавления в заказ введите название музыкального инструмента");
            System.out.println(str);
            System.out.println("Возврат в предыдущее меню - введите 0");

            String name = getIc().readString();

            if (name.equals("0")) {
                System.out.print("--------------------------------------");

                return;
            }

            System.out.println("Введите количество " + name + " в заказе");
            int n = getIc().readInt();
            if (n <= 0) {
                System.out.println("Количество элементов в заказе не должно быть отрицательное или нулевое");
                continue;
            }

            try {
                order.put(name, n);
                shop.prepareGoods(order);
                order.clear();
                System.out.println("--------------------------------------");
            } catch (InvalidKeyException invalidKey) {
                order.clear();
                System.out.println(invalidKey.toString());
            } catch (IllegalArgumentException e) {
                System.out.println("!!! Ошибка. Количество инструментов в заказе превышает их количество в наличии. Попробуйте еще раз !!!");
            }
        }
    }
}
