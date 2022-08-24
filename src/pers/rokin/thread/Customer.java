package pers.rokin.thread;

public class Customer implements Runnable{
    private Box b;
    public Customer(Box box) {
        this.b = box;
    }

    @Override
    public void run() {
//        for (int i = 1; i<=5; i++){
//            b.get();
//        }
        while (true)
            b.get();
    }
}
