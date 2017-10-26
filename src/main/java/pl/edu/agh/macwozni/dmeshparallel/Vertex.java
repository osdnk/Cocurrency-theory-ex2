package pl.edu.agh.macwozni.dmeshparallel;

class Vertex {
    //constructor

    Vertex(Vertex left, Vertex right, String lab) {
        this.mLeft = left;
        this.mRight = right;
        this.mLabel = lab;
    }
    //empty constructor

    Vertex() {
        this.mLeft = null;
        this.mRight = null;
    }
    //label
    String mLabel;
    //links to adjacent elements
    Vertex mLeft;
    Vertex mRight;
    //methods for adding links

    void setLeft(Vertex left) {
        mLeft = left;
    }

    void setRight(Vertex right) {
        mRight = right;
    }

    void setLabel(String lab) {
        mLabel = lab;
    }
}
