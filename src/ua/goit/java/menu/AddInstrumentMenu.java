package ua.goit.java.menu;

import ua.goit.java.controller.InputController;
import ua.goit.java.exception.InvalidKey;
import ua.goit.java.shop.Shop;

import java.io.IOException;

public class AddInstrumentMenu extends Menu {
    public AddInstrumentMenu(InputController ic) {
        super(ic);
    }

    @Override
    public void processMenu(Shop shop) throws IOException {
        while (true) {
            System.out.println("Для добавления введите название музыкального инструмента");
            System.out.println("(допустимые назвния \"guitar\", \"piano\" и \"trumpet\")");
            System.out.println("Возврат в предыдущее меню - введите 0");

            String name = InputController.br.readLine();

            if (name.equals("0")) {
                System.out.print("--------------------------------------");

                return;
            }

            System.out.println("Введите количество добавляемого музыкального инструмента " + name);
            int n = getIc().inputDataInt();

            try {
                shop.addNumberGoods(name, n);
                System.out.print("--------------------------------------");

                return;
            } catch (InvalidKey invalidKey) {
                System.out.println(invalidKey.toString());
            }
        }
    }
}
