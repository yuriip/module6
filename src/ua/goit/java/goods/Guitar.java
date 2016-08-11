package ua.goit.java.goods;

public class Guitar extends Goods implements Instrument {
    public Guitar(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println("Начать играть на гитаре");
    }

    @Override
    public void end() {
        System.out.println("Закончить играть на гитаре");
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
