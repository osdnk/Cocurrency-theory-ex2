package pl.edu.agh.macwozni.dmeshparallel.parallelism;

import pl.edu.agh.macwozni.dmeshparallel.myProductions.P2;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P6;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P1;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P5;
import pl.edu.agh.macwozni.dmeshparallel.myProductions.P3;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;
import pl.edu.agh.macwozni.dmeshparallel.mesh.GraphDrawer;
import pl.edu.agh.macwozni.dmeshparallel.production.PDrawer;

public class Executor extends Thread {

    @Override
    public void run() {

        BlockRunner runner = new ConcurentBlockRunner();
        PDrawer drawer = new GraphDrawer();
        //axiom
        Vertex s = new Vertex(null, null, "S");

        //p1 
        P1 p1 = new P1(s, drawer);
        runner.addThread(p1);

        //start threads
        runner.startAll();


        //p2,p3
        P2 p2 = new P2(p1.getObj(), drawer);
        P3 p3 = new P3(p1.getObj().getRight(), drawer);
        runner.addThread(p2);
        runner.addThread(p3);

        //start threads
        runner.startAll();

        //p5^2,p6^2
        P5 p5A = new P5(p2.getObj(), drawer);
        P5 p5B = new P5(p3.getObj().getRight(), drawer);
        P6 p6A = new P6(p2.getObj().getRight(), drawer);
        P6 p6B = new P6(p3.getObj(), drawer);
        runner.addThread(p5A);
        runner.addThread(p5B);
        runner.addThread(p6A);
        runner.addThread(p6B);

        //start threads
        runner.startAll();

        //done
        System.out.println("done");
        drawer.draw(p6B.getObj());

    }
}
