package ua.goit.java.goods;

public class Guitar extends Goods implements Instrument {
    public Guitar(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Играть на гитаре");
    }

    @Override
    public void sound() {
        System.out.println("Звучит гитара");
    }
}
