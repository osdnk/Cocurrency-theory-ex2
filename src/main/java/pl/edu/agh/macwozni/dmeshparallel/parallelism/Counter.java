package pl.edu.agh.macwozni.dmeshparallel.parallelism;

public class Counter {

    int mCounter;
    Thread mNotify;

    public Counter(Thread notify) {
        mCounter = 0;
        mNotify = notify;
    }

    public synchronized void inc() {
        mCounter++;
        System.out.println("Counter:" + mCounter);
    }

    public synchronized void dec() {
        if (mCounter > 0) {
            mCounter--;
        }
        System.out.println("Counter:" + mCounter);
        if (mCounter == 0) {
            System.out.println("Counter:notify()");
            notify();
        }
    }

    public synchronized void release() {
        try {
            System.out.println("Counter:wait");
            wait();
            System.out.println("Counter:release");
        } catch (InterruptedException e) {
            System.out.println("Counter:InterruptedException caught");
        }
    }
}
