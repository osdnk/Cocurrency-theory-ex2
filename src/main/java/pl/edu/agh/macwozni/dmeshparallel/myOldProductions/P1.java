package pl.edu.agh.macwozni.dmeshparallel.myOldProductions;

import pl.edu.agh.macwozni.dmeshparallel.parallelism.Counter;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;

public class P1 extends Production {

    public P1(Vertex vert, Counter count) {
        super(vert, count);
    }

    @Override
    public Vertex apply(Vertex s) {
        System.out.println("p1");
        Vertex t1 = new Vertex(null, null, "T1");
        Vertex t2 = new Vertex(t1, null, "T1");
        t1.setRight(t2);
        return t1;
    }
}
