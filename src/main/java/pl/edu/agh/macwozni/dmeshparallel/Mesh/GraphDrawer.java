package pl.edu.agh.macwozni.dmeshparallel;

class GraphDrawer {

    GraphDrawer() {
    }
    //draw the graph

    void draw(Vertex v) {
        //go left
        while (v.mLeft != null) {
            v = v.mLeft;
        }
        //plot
        while (v.mRight != null) {
            System.out.print(v.mLabel + "--");
            v = v.mRight;
        }
        System.out.println(v.mLabel);
    }
}
