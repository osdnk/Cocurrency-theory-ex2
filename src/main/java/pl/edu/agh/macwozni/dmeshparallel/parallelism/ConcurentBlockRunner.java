package pl.edu.agh.macwozni.dmeshparallel.parallelism;

import pl.edu.agh.macwozni.dmeshparallel.production.IProduction;

public class ConcurentBlockRunner extends AbstractBlockRunner{

    private final Object lock = new Object();
    
    @Override
    void runOne(IProduction _pOne) {
        _pOne.injectRefs(lock);
        _pOne.start();
    }

    @Override
    void wakeAll() {
        synchronized (lock) {
            lock.notifyAll();
        }
    }

}
