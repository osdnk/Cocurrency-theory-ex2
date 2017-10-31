package pl.edu.agh.macwozni.dmeshparallel.myProductions;

import pl.edu.agh.macwozni.dmeshparallel.parallelism.Counter;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;

public class P2 extends Production {

    public P2(Vertex vert, Counter count) {
        super(vert, count);
    }

    @Override
    public Vertex apply(Vertex t1) {
        System.out.println("p2");
        Vertex t2 = new Vertex(t1, t1.getRight(), "T2");
        t1.getRight().setLeft(t2);
        t1.setRight(t2);
        return t1;
    }
}
