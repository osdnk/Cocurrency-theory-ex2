package pl.edu.agh.macwozni.dmeshparallel;


class Vertex {
	//constructor
	Vertex(Vertex Left, Vertex Right, String Lab){
		this.m_left=Left;
		this.m_right=Right;
		this.m_label=Lab;
	}
	//empty constructor
	Vertex(){
		this.m_left=null;
		this.m_right=null;
	}
	//label
	String m_label;
	//links to adjacent elements
	Vertex m_left;
	Vertex m_right;
	//methods for adding links
	void set_left(Vertex Left){
		m_left=Left;
	}
	void set_right(Vertex Right){
		m_right=Right;
	}
	void set_label(String Lab){
		m_label=Lab;
	}
}
