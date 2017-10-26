package pl.edu.agh.macwozni.dmeshparallel.production;

import pl.edu.agh.macwozni.dmeshparallel.Counter;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;

public class P6 extends Production {

    public P6(Vertex vert, Counter count) {
        super(vert, count);
    }

    @Override
    public Vertex apply(Vertex t2) {
        System.out.println("p6");
        t2.setLabel("Iel2");
        return t2;
    }
}
