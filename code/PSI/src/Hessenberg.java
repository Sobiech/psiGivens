/**
 * Created by Kacper on 2015-03-27.
 */
public class Hessenberg {

    private long last;
    public double[][] hessenbergMatrix;

    public Hessenberg() {this(System.currentTimeMillis());}
    public Hessenberg(long seed) {
        this.last = seed;

    }

    public double nextInt(int max) {
        max=(max+1)*100;
        last ^= (last << 21);
        last ^= (last >>> 35);
        last ^= (last << 4);
        double out = (int) last % max;
        out = (out == 0)? nextInt(max) : out/100;
        return (out < 0) ? -out : out;
    }

    public void generateMatrix(int wielkosc,int zakres){

        hessenbergMatrix = new double[wielkosc][wielkosc];

        for(int i=0;i<wielkosc;i++)
            for(int j=(i>1)?i-1:0;j<wielkosc;j++)
                    hessenbergMatrix[i][j]=nextInt(zakres);

    }

    public double[][] getMatrix(){
        return hessenbergMatrix;
    }


    public void printMatrix(){
        for(int i=0;i<hessenbergMatrix.length;i++) {
            System.out.println();
            for (int j = 0; j < hessenbergMatrix[i].length; j++)
                System.out.print(hessenbergMatrix[i][j] + ",");
        }
    }


}
