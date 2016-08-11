package ua.goit.java.goods;

public class Piano extends Goods implements Instrument {
    public Piano(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println("Начать играть на фортепиано");
    }

    @Override
    public void end() {
        System.out.println("Закончить играть на фортепиано");
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
