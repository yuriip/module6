package ua.goit.java.goods;

public class Trumpet extends Goods implements Instrument {
    public Trumpet(String name) {
        super(name);
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
