package pl.edu.agh.macwozni.dmeshparallel.production;


public interface IProduction<P> {
    
    public P apply(P _p);
    
    public void join() throws InterruptedException;
    
    public void run();
    
    public void start();
    
    public void injectRefs(Object _lock);
}
