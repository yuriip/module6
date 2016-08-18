package ua.goit.java.shop;

import ua.goit.java.exception.InvalidKeyException;
import ua.goit.java.goods.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Shop {
    private String name;
    private String address;
    private Map<String, Integer> goods;
    private Map<String, Integer> lastOrder;

    public Shop(String name) {
        this.name = name;
        goods = new HashMap<>();
        lastOrder = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, Integer> getGoods() {
        return goods;
    }

    public Map<String, Integer> getLastOrder() {
        return lastOrder;
    }

    public void addNumberGoods(String name, int n) throws InvalidKeyException, IllegalArgumentException {
        if (goods.containsKey(name)) {
            n = n + this.goods.get(name);
            goods.put(name, n);
        } else {
            throw new InvalidKeyException("!!! Ошибка. Неверный тип товара. Необходимо ввести допустимый тип товара. Попробуйте еще раз !!!");
        }
    }

    public void validateOrder(Map.Entry<String, Integer> item) throws InvalidKeyException {
        String keyName = item.getKey();
        int numberInstruments = item.getValue();

        if (goods.containsKey(keyName)) {
            int numGoods = goods.get(keyName);
            if (numberInstruments > numGoods) {
                throw new IllegalArgumentException("Количество инструментов в заказе превышает их количество в наличии");
            } else {
                goods.put(keyName, numGoods - numberInstruments);
                numberInstruments = numberInstruments + lastOrder.get(keyName);
                lastOrder.put(keyName, numberInstruments);
            }
        } else {
            throw new InvalidKeyException("!!! Ошибка. Неверный тип товара. Необходимо ввести допустимый тип товара. Попробуйте еще раз !!!");
        }
    }

    public abstract void listGoodsFromMap(Map<String, Integer> goods);

    public abstract List<Goods> prepareGoods(Map<String, Integer> order) throws InvalidKeyException, IllegalArgumentException;
}
