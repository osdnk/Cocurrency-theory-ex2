package pl.edu.agh.macwozni.dmeshparallel.production;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractProduction<P> implements IProduction<P> {

    private Object lock;
    private final PThread thread = new PThread();
    private final P obj;
    private P result;
    
    public AbstractProduction(P _obj){
        this.obj = _obj;
    }
    
    //run the thread
    @Override
    public void run() {
        thread.run();
    }
    
    @Override
    public void join() throws InterruptedException{
            thread.join();
    }
    
    @Override
    public void injectRefs(Object _lock){
        this.lock = _lock;
    }
    
    
    
    private class PThread extends Thread{
        @Override
        public void run() {
            synchronized(lock){
                try {
                    lock.wait();
                    result = apply(obj);
                    // TODO draw
                } catch (InterruptedException ex) {
                    Logger.getLogger(AbstractProduction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
