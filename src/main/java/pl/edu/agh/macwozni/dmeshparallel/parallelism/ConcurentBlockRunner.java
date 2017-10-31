package pl.edu.agh.macwozni.dmeshparallel.parallelism;

import pl.edu.agh.macwozni.dmeshparallel.production.IProduction;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurentBlockRunner extends AbstractBlockRunner {

    private final MyLock lock = new MyLock();

    @Override
    void runOne(IProduction _pOne) {
        _pOne.injectRefs(lock);
        _pOne.start();
    }

    @Override
    void wakeAll() {
        lock.unlock();
    }

}
