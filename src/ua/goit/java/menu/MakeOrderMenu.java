package ua.goit.java.menu;

import ua.goit.java.controller.InputController;
import ua.goit.java.exception.InvalidKey;
import ua.goit.java.shop.Shop;

import java.io.IOException;

public class MakeOrderMenu extends Menu {
    public MakeOrderMenu(InputController ic) {
        super(ic);
    }

    @Override
    public void processMenu(Shop shop) throws IOException {
        while (true) {
            System.out.println("Для поставки музыкальных инструментов необходимо создать заказ");
            System.out.println("В наличии есть следующие музыкальные инструменты:");
            shop.listGoodsFromMap();
            System.out.println("Для добавления в заказ введите название музыкального инструмента");
            System.out.println("(Допустимые назвния \"guitar\", \"piano\" и \"trumpet\")");
            System.out.println("Возврат в предыдущее меню - введите 0");

            String name = InputController.br.readLine();

            if (name.equals("0")) {
                System.out.print("--------------------------------------");

                return;
            }

            System.out.println("Введите количество " + name + " в заказе");
            int n = getIc().inputDataInt();
            if (n <= 0) {
                System.out.println("Количество элементов в заказе не должно быть отрицательное или нулевое");
                continue;
            }
            try {
                shop.addOrder(name, n);
                System.out.println("Заказ сформирован");
                System.out.print("--------------------------------------");

                return;
            } catch (InvalidKey invalidKey) {
                System.out.println(invalidKey.toString());
            } catch (IllegalArgumentException e) {
                System.out.println("!!! Ошибка. Количество инструментов в заказе превышает их количество в наличии. Попробуйте еще раз !!!");
            }
        }
    }
}
