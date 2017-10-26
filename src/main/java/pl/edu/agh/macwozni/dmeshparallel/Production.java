package pl.edu.agh.macwozni.dmeshparallel;

abstract class Production extends Thread {

    Production(Vertex Vert, Counter Count) {
        mVertex = Vert;
        mCounter = Count;
        mDrawer = new GraphDrawer();
    }

    //returns first vertex from the left
    abstract Vertex apply(Vertex v);

    //run the thread
    public void run() {
        mCounter.inc();
        //apply the production
        mVertex = apply(mVertex);
        //plot the graph
        mDrawer.draw(mVertex);
        mCounter.dec();
    }

    //vertex where the production will be applied
    Vertex mVertex;
    //graph drawer
    GraphDrawer mDrawer;
    //productions counter
    Counter mCounter;
}

class P1 extends Production {

    P1(Vertex vert, Counter count) {
        super(vert, count);
    }

    Vertex apply(Vertex s) {
        System.out.println("p1");
        Vertex t1 = new Vertex(null, null, "T1");
        Vertex t2 = new Vertex(t1, null, "T1");
        t1.setRight(t2);
        return t1;
    }
}

class P2 extends Production {

    P2(Vertex vert, Counter count) {
        super(vert, count);
    }

    Vertex apply(Vertex t1) {
        System.out.println("p2");
        Vertex t2 = new Vertex(t1, t1.mRight, "T2");
        t1.mRight.setLeft(t2);
        t1.setRight(t2);
        return t1;
    }
}

class P3 extends Production {

    P3(Vertex vert, Counter count) {
        super(vert, count);
    }

    Vertex apply(Vertex t1) {
        System.out.println("p3");
        Vertex t2 = new Vertex(t1.mLeft, t1, "T2");
        t1.mLeft.setRight(t2);
        t1.setLeft(t2);
        return t2;
    }
}

class P4 extends Production {

    P4(Vertex vert, Counter count) {
        super(vert, count);
    }

    Vertex apply(Vertex t2) {
        System.out.println("p4");
        Vertex t2Prim = new Vertex(t2, null, "T2");
        t2.setRight(t2Prim);
        return t2;
    }
}

class P5 extends Production {

    P5(Vertex vert, Counter count) {
        super(vert, count);
    }

    Vertex apply(Vertex t1) {
        System.out.println("p5");
        t1.setLabel("Iel1");
        return t1;
    }
}

class P6 extends Production {

    P6(Vertex vert, Counter count) {
        super(vert, count);
    }

    Vertex apply(Vertex t2) {
        System.out.println("p6");
        t2.setLabel("Iel2");
        return t2;
    }
}
