package pers.rokin.lock;

public class SellTicketDemo {
    public static void main(String[] args) {
        SellTicket st = new SellTicket();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        Thread t3 = new Thread(st);

        t1.start();
        t2.start();
        t3.start();
    }
}
