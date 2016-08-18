package ua.goit.java.menu;

import ua.goit.java.controller.InputController;
import ua.goit.java.shop.Shop;

import java.io.IOException;

public class MainMenu extends Menu {
    public MainMenu(InputController ic) {
        super(ic);
        menus.add(0, new CatalogInstrumentMenu(ic));
        menus.add(1, new AddInstrumentMenu(ic));
        menus.add(2, new MakeOrderMenu(ic));
        menus.add(3, new ViewOrder(ic));
    }

    @Override
    public void processMenu(Shop shop) throws IOException {
        while (true) {
            System.out.println("<<< Магазин \"" + shop.getName() + "\" >>>");
            System.out.println("Каталог музыкальных инструментов, которые есть в наличии - введите 1");
            System.out.println("Добавление музыкальных инструментов в магазин - введите 2");
            System.out.println("Сформировать заказ на поставку музыкальных инструментов - введите 3");
            System.out.println("Посмотреть заказанные музыкальные инструменты - введите 4");
            System.out.println("Выход из программы - введите 0");

            int n = getIc().readInt();

            switch (n) {
                case 1:
                    getMenus().get(n - 1).processMenu(shop);
                    break;
                case 2:
                    getMenus().get(n - 1).processMenu(shop);
                    break;
                case 3:
                    getMenus().get(n - 1).processMenu(shop);
                    break;
                case 4:
                    getMenus().get(n - 1).processMenu(shop);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("!!! Выбор не сделан, попробуйте еще раз !!!");
            }
            System.out.println();
        }
    }
}
