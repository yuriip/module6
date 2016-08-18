package ua.goit.java.goods;

public class Piano extends Goods implements Instrument {
    public Piano(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Играть на фортепиано");
    }

    @Override
    public void sound() {
        System.out.println("Звучит фортепиано");
    }
}
