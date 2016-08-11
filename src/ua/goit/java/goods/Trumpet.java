package ua.goit.java.goods;

public class Trumpet extends Goods implements Instrument {
    public Trumpet(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println("Начать играть на трубе");
    }

    @Override
    public void end() {
        System.out.println("Закончить играть на трубе");
    }

    @Override
    public void play() {
        System.out.println("Играть на трубе");
    }

    @Override
    public void sound() {
        System.out.println("Звучит труба");
    }
}
