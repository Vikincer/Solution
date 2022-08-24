package pers.rokin.thread;

public class Box {
    private  int milk;
    private boolean state = false;

    public synchronized void put(int milk){
        if(state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.milk = milk;
        System.out.println("送奶工将第" +this.milk + "放入奶箱中");
        state = true;

        notifyAll();
    }
    public synchronized void get(){
        if(!state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("用户拿到第" + this.milk + "瓶奶");
        state = false;

        notifyAll();
    }
}
