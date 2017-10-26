package pl.edu.agh.macwozni.dmeshparallel.Mesh;

public class Vertex {

    //label
    String mLabel = null;
    //links to adjacent elements
    Vertex mLeft = null;
    Vertex mRight = null;

    //methods for adding links
    public Vertex(Vertex left, Vertex right, String lab) {
        this.mLeft = left;
        this.mRight = right;
        this.mLabel = lab;
    }
    //empty constructor

    public Vertex() {
    }

    public void setLeft(Vertex left) {
        mLeft = left;
    }

    public void setRight(Vertex right) {
        mRight = right;
    }

    public void setLabel(String lab) {
        mLabel = lab;
    }

    public Vertex getLeft() {
        return mLeft;
    }

    public Vertex getRight() {
        return mRight;
    }

    public String getLabel() {
        return mLabel;
    }
}
