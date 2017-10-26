package pl.edu.agh.macwozni.dmeshparallel.parallelism;

public interface BlockRunner {

    //starts all threads
    public void startAll();

    //adds a thread to poll
    public void addThread();
}
