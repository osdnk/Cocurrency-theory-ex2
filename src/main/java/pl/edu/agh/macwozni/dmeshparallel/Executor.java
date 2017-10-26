package pl.edu.agh.macwozni.dmeshparallel;


class Executor extends Thread {
	public synchronized void run() {

	  	Counter counter = new Counter(this);
		//axiom
		Vertex S = new Vertex(null,null,"S");

		//p1 
		P1 p1 = new P1(S,counter);
		p1.start();
		
		counter.release();
		
		//p2,p3
		P2 p2 = new P2(p1.m_vertex,counter);
		P3 p3 = new P3(p1.m_vertex.m_right,counter);
		p2.start();
		p3.start();

		counter.release();
		
		//p5^2,p6^2
		P5 p5a = new P5(p2.m_vertex,counter);
		P5 p5b = new P5(p3.m_vertex.m_right,counter);
		P6 p6a = new P6(p2.m_vertex.m_right,counter);
		P6 p6b = new P6(p3.m_vertex,counter);
		p5a.start();
		p5b.start();
		p6a.start();
		p6b.start();

		counter.release();
		
		//done
		System.out.println("done");
		GraphDrawer drawer = new GraphDrawer();
		drawer.draw(p6b.m_vertex);

	}
}
