package pl.edu.agh.macwozni.dmeshparallel.production;

import pl.edu.agh.macwozni.dmeshparallel.parallelism.Counter;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;

public class P5 extends Production {

    public P5(Vertex vert, Counter count) {
        super(vert, count);
    }

    @Override
    public Vertex apply(Vertex t1) {
        System.out.println("p5");
        t1.setLabel("Iel1");
        return t1;
    }
}
