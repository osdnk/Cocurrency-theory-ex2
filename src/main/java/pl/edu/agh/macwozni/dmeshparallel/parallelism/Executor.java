package pl.edu.agh.macwozni.dmeshparallel.parallelism;

import pl.edu.agh.macwozni.dmeshparallel.production.P2;
import pl.edu.agh.macwozni.dmeshparallel.production.P6;
import pl.edu.agh.macwozni.dmeshparallel.production.P1;
import pl.edu.agh.macwozni.dmeshparallel.production.P5;
import pl.edu.agh.macwozni.dmeshparallel.production.P3;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;
import pl.edu.agh.macwozni.dmeshparallel.mesh.GraphDrawer;

public class Executor extends Thread {

    @Override
    public synchronized void run() {

        Counter counter = new Counter(this);
        //axiom
        Vertex s = new Vertex(null, null, "S");

        //p1 
        P1 p1 = new P1(s, counter);
        p1.start();

        counter.release();

        //p2,p3
        P2 p2 = new P2(p1.getVertex(), counter);
        P3 p3 = new P3(p1.getVertex().getRight(), counter);
        p2.start();
        p3.start();

        counter.release();

        //p5^2,p6^2
        P5 p5A = new P5(p2.getVertex(), counter);
        P5 p5B = new P5(p3.getVertex().getRight(), counter);
        P6 p6A = new P6(p2.getVertex().getRight(), counter);
        P6 p6B = new P6(p3.getVertex(), counter);
        p5A.start();
        p5B.start();
        p6A.start();
        p6B.start();

        counter.release();

        //done
        System.out.println("done");
        GraphDrawer drawer = new GraphDrawer();
        drawer.draw(p6B.getVertex());

    }
}
