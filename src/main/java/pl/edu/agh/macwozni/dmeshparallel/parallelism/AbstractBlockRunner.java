package pl.edu.agh.macwozni.dmeshparallel.parallelism;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import pl.edu.agh.macwozni.dmeshparallel.production.IProduction;

public abstract class AbstractBlockRunner implements BlockRunner {

    private final AbstractQueue<IProduction> list = new ConcurrentLinkedQueue<IProduction>();

    //starts all threads
    @Override
    public void startAll() {
        Iterator<IProduction> iter = list.iterator();
        while (iter.hasNext()){
            IProduction p = iter.next();
            runOne(p);
        }
        wakeAll();
        list.clear();
    }

    //adds a thread to poll
    @Override
    public void addThread(IProduction pThread) {
        list.add(pThread);
    }

    //starts one thread
    abstract void runOne(IProduction pOne);
    
    //wakes all threads
    abstract void wakeAll();
}
