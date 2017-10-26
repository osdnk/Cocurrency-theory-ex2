package pl.edu.agh.macwozni.dmeshparallel;

abstract class Production extends Thread {

    Production(Vertex Vert, Counter Count) {
        m_vertex = Vert;
        m_counter = Count;
        m_drawer = new GraphDrawer();
    }

    //returns first vertex from the left
    abstract Vertex apply(Vertex v);

    //run the thread
    public void run() {
        m_counter.inc();
        //apply the production
        m_vertex = apply(m_vertex);
        //plot the graph
        m_drawer.draw(m_vertex);
        m_counter.dec();
    }

    //vertex where the production will be applied
    Vertex m_vertex;
    //graph drawer
    GraphDrawer m_drawer;
    //productions counter
    Counter m_counter;
}

class P1 extends Production {

    P1(Vertex Vert, Counter Count) {
        super(Vert, Count);
    }

    Vertex apply(Vertex S) {
        System.out.println("p1");
        Vertex T1 = new Vertex(null, null, "T1");
        Vertex T2 = new Vertex(T1, null, "T1");
        T1.set_right(T2);
        return T1;
    }
}

class P2 extends Production {

    P2(Vertex Vert, Counter Count) {
        super(Vert, Count);
    }

    Vertex apply(Vertex T1) {
        System.out.println("p2");
        Vertex T2 = new Vertex(T1, T1.m_right, "T2");
        T1.m_right.set_left(T2);
        T1.set_right(T2);
        return T1;
    }
}

class P3 extends Production {

    P3(Vertex Vert, Counter Count) {
        super(Vert, Count);
    }

    Vertex apply(Vertex T1) {
        System.out.println("p3");
        Vertex T2 = new Vertex(T1.m_left, T1, "T2");
        T1.m_left.set_right(T2);
        T1.set_left(T2);
        return T2;
    }
}

class P4 extends Production {

    P4(Vertex Vert, Counter Count) {
        super(Vert, Count);
    }

    Vertex apply(Vertex T2) {
        System.out.println("p4");
        Vertex T2prim = new Vertex(T2, null, "T2");
        T2.set_right(T2prim);
        return T2;
    }
}

class P5 extends Production {

    P5(Vertex Vert, Counter Count) {
        super(Vert, Count);
    }

    Vertex apply(Vertex T1) {
        System.out.println("p5");
        T1.set_label("Iel1");
        return T1;
    }
}

class P6 extends Production {

    P6(Vertex Vert, Counter Count) {
        super(Vert, Count);
    }

    Vertex apply(Vertex T2) {
        System.out.println("p6");
        T2.set_label("Iel2");
        return T2;
    }
}
