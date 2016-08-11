package ua.goit.java.shop;

import ua.goit.java.goods.Goods;
import ua.goit.java.goods.Guitar;
import ua.goit.java.goods.Piano;
import ua.goit.java.goods.Trumpet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MusicalShop extends Shop {
    private final String[] typesGoods = new String[]{"guitar", "piano", "trumpet"};

    public MusicalShop(String name) {
        super(name);
        for (String key : typesGoods) {
            getGoods().put(key, 0);
            getOrders().put(key, 0);
        }
    }

    @Override
    public void listGoodsFromMap() {
        Map<String, Integer> goods = getGoods();
        if (goods != null) {
            for (Map.Entry<String, Integer> item : goods.entrySet()) {
                System.out.println(item.getKey() + ", количество: " + item.getValue());
            }
        }
    }

    @Override
    public List<Goods> prepareGoods(Map<String, Integer> order) {
        List<Goods> listGoodsOrder = mapGoodsToList(order);

        return listGoodsOrder;
    }

    private List<Goods> mapGoodsToList(Map<String, Integer> goods) {
        List<Goods> listGoodsOrder = new ArrayList<>();

        if (goods != null) {
            for (Map.Entry<String, Integer> item : goods.entrySet()) {
                for (int i = 0; i < typesGoods.length; i++) {
                    if (typesGoods[i].equals(item.getKey())) {
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
