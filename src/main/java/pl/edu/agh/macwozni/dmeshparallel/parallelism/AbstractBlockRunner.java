package pl.edu.agh.macwozni.dmeshparallel.parallelism;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import pl.edu.agh.macwozni.dmeshparallel.production.P;

public abstract class AbstractBlockRunner implements BlockRunner {

    private final AbstractQueue<P> list = new ConcurrentLinkedQueue<P>();

    //starts all threads
    @Override
    public void startAll() {
        Iterator<P> iter = list.iterator();
        while (iter.hasNext()){
            P p = iter.next();
            runOne(p);
        }
        wakeAll();
        list.clear();
    }

    //adds a thread to poll
    @Override
    public void addThread(P pThread) {
        list.add(pThread);
    }

    //starts one thread
    abstract void runOne(P pOne);
    
    //wakes all threads
    abstract void wakeAll();
}
