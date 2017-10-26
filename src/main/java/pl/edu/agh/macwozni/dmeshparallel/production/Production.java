package pl.edu.agh.macwozni.dmeshparallel.production;

import pl.edu.agh.macwozni.dmeshparallel.Counter;
import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;
import pl.edu.agh.macwozni.dmeshparallel.mesh.GraphDrawer;

abstract public class Production extends Thread {

    //vertex where the production will be applied
    Vertex mVertex;
    //graph drawer
    GraphDrawer mDrawer;
    //productions counter
    Counter mCounter;

    public Production(Vertex Vert, Counter Count) {
        mVertex = Vert;
        mCounter = Count;
        mDrawer = new GraphDrawer();
    }

    //returns first vertex from the left
    public abstract Vertex apply(Vertex v);

    //run the thread
    @Override
    public void run() {
        mCounter.inc();
        //apply the production
        mVertex = apply(mVertex);
        //plot the graph
        mDrawer.draw(mVertex);
        mCounter.dec();
    }
    
    public Vertex getVertex(){
        return mVertex;
    }
            
}
