package ua.goit.java.shop;

import ua.goit.java.exception.InvalidKey;
import ua.goit.java.goods.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Shop {
    private String name;
    private String address;
    private Map<String, Integer> goods;
    private Map<String, Integer> orders;

    public Shop(String name) {
        this.name = name;
        this.goods = new HashMap<>();
        this.orders = new HashMap<>();
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

    public Map<String, Integer> getOrders() {
        return orders;
    }

    public void addNumberGoods(String name, int n) throws InvalidKey, IllegalArgumentException {
        if (this.goods.containsKey(name)) {
            n = n + this.goods.get(name);
            this.goods.put(name, n);
        } else {
            throw new InvalidKey("!!! Ошибка. Неверный тип товара. Необходимо ввести допустимый тип товара. Попробуйте еще раз !!!");
        }
    }

    public void addOrder(String name, int n) throws InvalidKey {
        if (this.orders.containsKey(name)) {
            int numGoods = this.goods.get(name);
            if (n > numGoods) {
                throw new IllegalArgumentException("Количество инструментов в заказе превышает их количество в наличии");
            } else {
                this.goods.put(name, numGoods - n);
                n = n + this.orders.get(name);
                this.orders.put(name, n);
            }
        } else {
            throw new InvalidKey("!!! Ошибка. Неверный тип товара. Необходимо ввести допустимый тип товара. Попробуйте еще раз !!!");
        }
    }

    public abstract void listGoodsFromMap();

    public abstract List<Goods> prepareGoods(Map<String, Integer> order);
}
