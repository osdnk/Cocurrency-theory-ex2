package pl.edu.agh.macwozni.dmeshparallel;

import pl.edu.agh.macwozni.dmeshparallel.parallelism.OldExecutor;

class Application {

    public static void main(String args[]) {

        OldExecutor e = new OldExecutor();
        e.start();
    }
}
