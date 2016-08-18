package ua.goit.java.menu;

import ua.goit.java.controller.InputController;
import ua.goit.java.enums.TypesGoods;
import ua.goit.java.exception.InvalidKeyException;
import ua.goit.java.shop.Shop;

import java.io.IOException;

public class AddInstrumentMenu extends Menu {
    public AddInstrumentMenu(InputController ic) {
        super(ic);
    }

    @Override
    public void processMenu(Shop shop) throws IOException {
        while (true) {
            StringBuilder str = new StringBuilder("(допустимые назвния ");
            for (TypesGoods type : TypesGoods.values()) {
                str.append(type.toString().toLowerCase() + ", ");
            }
            str.setLength(str.length() - 2);
            str.append(")");

            System.out.println("Для добавления введите название музыкального инструмента");
            System.out.println(str);
            System.out.println("Возврат в предыдущее меню - введите 0");

            String name = getIc().readString();

            if (name.equals("0")) {
                System.out.print("--------------------------------------");

                return;
            }

            System.out.println("Введите количество добавляемых музыкальных инструментов " + name);
            int n = getIc().readInt();
            if (n <= 0) {
                System.out.println("Количество добавляемых музыкальных инструментов элементов не должно быть отрицательным или нулевым");
                System.out.println("--------------------------------------");

                continue;
            }

            try {
                shop.addNumberGoods(name, n);
                System.out.println("--------------------------------------");
            } catch (InvalidKeyException invalidKey) {
                System.out.println(invalidKey.toString());
            }
        }
    }
}
