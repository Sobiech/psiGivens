import java.lang.reflect.Array;

/**
 * Created by Kacper on 2015-03-25.
 */
public class main {

    public static void main(String[] args) {

        Hessenberg hessenberg = new Hessenberg();
        hessenberg.generateMatrix(15,23);

        Givens givens = new Givens(hessenberg.getMatrix());
        givens.generateMatrix();
        hessenberg.printMatrix();
        givens.printMatrix(givens.getGivensMatrix());
        givens.printMatrix(givens.getResultMatrix());
    }



}
