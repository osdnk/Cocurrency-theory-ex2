package pl.edu.agh.macwozni.dmeshparallel.parallelism;

import pl.edu.agh.macwozni.dmeshparallel.production.IProduction;

public class SerialBlockRunner extends AbstractBlockRunner {

    private final Object lock = new Object();

    @Override
    void runOne(IProduction _pOne) {
        _pOne.injectRefs(lock);
        _pOne.start();
        synchronized (lock) {
            lock.notify();
        }
    }

    @Override
    void wakeAll() {
        //do nothing
    }

}
