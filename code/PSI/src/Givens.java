import java.util.Arrays;

/**
 * Created by Kacper on 2015-03-27.
 */
public class Givens {

    private double[][] givensMatrix;
    private double[][] resultMatrix;

    public Givens(double[][] hesMatrix){
        this.givensMatrix=(tableCopy(hesMatrix,givensMatrix));
        this.resultMatrix=(tableCopy(hesMatrix,this.resultMatrix));
    }

    private double[][] tableCopy(double[][] tabl1,double[][] tabl2){
        tabl2 = new double[tabl1.length][tabl1.length];
        for(int i=0;i<tabl1.length;i++)
            for(int j=0;j<tabl1[i].length;j++)
                tabl2[i][j]=tabl1[i][j];

        return tabl2;
    }


   public void generateMatrix(){
        double temp;
        double c[][] = new double[givensMatrix.length][givensMatrix.length];
        double s[][] = new double[givensMatrix.length][givensMatrix.length];


       for(int i=0;i<givensMatrix.length;i++){
           for(int j=i+1;j<givensMatrix.length;j++){
               temp = givensMatrix[i][i];
               givensMatrix[i][i]=getFunc(givensMatrix[i][i],givensMatrix[j][i]);
               c[j][i]=temp/givensMatrix[i][i];
               s[j][i]=givensMatrix[j][i]/givensMatrix[i][i];

           }


           for(int j=i+1;j<givensMatrix.length;j++)
               for(int k=i+1;k<givensMatrix.length;k++)
               {
                   temp = c[j][i]*givensMatrix[i][k]+s[j][i]*givensMatrix[j][k];
                   givensMatrix[j][k]= (-s[j][i])*givensMatrix[i][k]+c[j][i]*givensMatrix[j][k];
                   givensMatrix[i][k]=temp;
               }
       }

       for(int i=0;i<givensMatrix.length;i++)
           for(int j=0;j<givensMatrix[i].length;j++)
               resultMatrix[i][j]-=givensMatrix[i][j];


       roundElements(givensMatrix,2);
       roundElements(resultMatrix,2);

    }

    private double getFunc(double a,double b){
        return Math.sqrt((a*a+b*b));
    }

    public double[][] getGivensMatrix(){return givensMatrix;}
    public double[][] getResultMatrix(){return resultMatrix;}

    public void printMatrix(double[][] matrix){
        for(int i=0;i<matrix.length;i++) {
            System.out.println();
            for (int j = 0; j <matrix[i].length; j++)
                System.out.print(matrix[i][j] + ",");
        }
    }


    private void roundElements(double[][] tabl,int round){
        double round2 = Math.pow(10.0,round);
        for(int i=0;i<tabl.length;i++)
            for(int j=0;j<tabl[i].length;j++)
                tabl[i][j]=Math.round(tabl[i][j]*round2)/round2;
    }
}
