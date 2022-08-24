package pers.rokin.thread;

public class Producer implements Runnable{
    private Box b;

    public Producer(Box box) {
        this.b = box;
    }

    @Override
    public void run() {
        for (int i = 1; i<=5; i++){
            b.put(i);
        }
    }
}
