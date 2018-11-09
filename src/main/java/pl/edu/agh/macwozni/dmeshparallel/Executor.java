package pl.edu.agh.macwozni.dmeshparallel;

import pl.edu.agh.macwozni.dmeshparallel.mesh.Vertex;
import pl.edu.agh.macwozni.dmeshparallel.mesh.GraphDrawer;
import pl.edu.agh.macwozni.dmeshparallel.parallelism.BlockRunner;
import pl.edu.agh.macwozni.dmeshparallel.production.AbstractProduction;
import pl.edu.agh.macwozni.dmeshparallel.production.PDrawer;


public class Executor extends Thread {
    
    private final BlockRunner runner;
    
    Executor(BlockRunner _runner){
        this.runner = _runner;
    }

    public static final class PE extends AbstractProduction<Vertex> {
        Vertex[][] mRes;
        PE(Vertex _obj, PDrawer<Vertex> _drawer, Vertex[][] res) {
            super(_obj, _drawer);
            this.mRes = res;
        }

        @Override
        public Vertex apply(Vertex s) {
            Vertex t1 = new Vertex(s.x + 1 , s.y);
            mRes[t1.y][t1.x] = t1;
            return t1;
        }
    }

    public static final class PS extends AbstractProduction<Vertex> {
        Vertex[][] mRes;
        PS(Vertex _obj, PDrawer<Vertex> _drawer, Vertex[][] res) {
            super(_obj, _drawer);
            this.mRes = res;
        }

        @Override
        public Vertex apply(Vertex s) {
            Vertex t1 = new Vertex(s.x , s.y + 1);
            mRes[t1.y][t1.x] = t1;
            return t1;
        }
    }

    @Override
    public void run() {
        PDrawer drawer = new GraphDrawer();
        Vertex s = new Vertex(0,0);
        int N = 104;
        Vertex[][] res = new Vertex[N][N];
        res[0][0] = s;
        for (int n = 1; n <=2 * N - 2; n++) {
            for (int i = 0; i <= N - 1; i++) {
                int j = n - 1 - i;
                if (j >= 0 && j < N  - 1) {
                    Vertex v = res[i][j];
                    PE p = new PE(v, drawer, res);
                    this.runner.addThread(p);
                }
            }
            if (n <= N - 1) {
                Vertex v = res[n-1][0];
                PS p = new PS(v, drawer, res);
                this.runner.addThread(p);
            }
            this.runner.startAll();
        }

        for (int i = 0; i< N; i ++) {
            for (int j = 0; j< N; j ++) {
                if (res[i][j] == null) {
                    // if any of block is null our algorithm is incorrect
                    System.out.println("XXXXXXX");
                }
            }
        }
    }
}
