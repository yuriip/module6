package ua.goit.java.shop;

import ua.goit.java.enums.TypesGoods;
import ua.goit.java.exception.InvalidKey;
import ua.goit.java.goods.Goods;
import ua.goit.java.goods.Guitar;
import ua.goit.java.goods.Piano;
import ua.goit.java.goods.Trumpet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MusicalShop extends Shop {

    public MusicalShop(String name) {
        super(name);

        for (TypesGoods type : TypesGoods.values()) {
            getGoods().put(type.toString().toLowerCase(), 0);
            getOrders().put(type.toString().toLowerCase(), 0);
        }
    }

    @Override
    public void listGoodsFromMap(Map<String, Integer> map) {
        if (map != null) {
            for (Map.Entry<String, Integer> item : map.entrySet()) {
                System.out.println(item.getKey() + ", количество: " + item.getValue());
            }
        }
    }

    public List<Goods> prepareGoods(Map<String, Integer> order) throws InvalidKey, IllegalArgumentException {
        List<Goods> listGoodsOrder = new ArrayList<>();
        TypesGoods[] typesGoods = TypesGoods.values();

        if (order != null) {
            for (Map.Entry<String, Integer> item : order.entrySet()) {
                addOrder(item.getKey(), item.getValue());

                for (int i = 0; i < typesGoods.length; i++) {
                    if (typesGoods[i].toString().equals(item.getKey())) {
                        switch (i) {
                            case 0:
                                for (int j = 0; j < item.getValue(); j++) {
                                    listGoodsOrder.add(new Guitar(item.getKey()));
                                }
                                break;
                            case 1:
                                for (int j = 0; j < item.getValue(); j++) {
                                    listGoodsOrder.add(new Piano(item.getKey()));
                                }
                                break;
                            case 2:
                                for (int j = 0; j < item.getValue(); j++) {
                                    listGoodsOrder.add(new Trumpet(item.getKey()));
                                }
                                break;
                        }
                    }
                }
            }
        }

        return listGoodsOrder;
    }
}
