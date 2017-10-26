package pl.edu.agh.macwozni.dmeshparallel.production;

import pl.edu.agh.macwozni.dmeshparallel.parallelism.Counter;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;

public class P3 extends Production {

    public P3(Vertex vert, Counter count) {
        super(vert, count);
    }

    @Override
    public Vertex apply(Vertex t1) {
        System.out.println("p3");
        Vertex t2 = new Vertex(t1.getLeft(), t1, "T2");
        t1.getLeft().setRight(t2);
        t1.setLeft(t2);
        return t2;
    }
}
