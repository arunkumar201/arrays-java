import java.util.Arrays;


public class Initialization {

    public static void main(String[] args) {
        int[] a1 = new int[5];
        System.out.println(a1.length);
        int [] a2;
        a2=new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(a2));

        float[] fa=new float[]{1.2f,2.3f,3.4f,4.5f,5.6f};
        System.out.println(fa.length);
        System.out.println(Arrays.toString(fa));

        double [] d1=new double[]{12.2,22,2.3,4.5,5.6};
        System.out.println(d1.length);
        System.out.println(Arrays.toString(d1));

        boolean [] b=new boolean[]{true,false,true,false,true,false};
        System.out.println(b.length);
        System.out.println(Arrays.toString(b));


        char [] ch=new char[]{'1','2','3','4','5','a','b','c'};
        System.out.println(ch.length);
        System.out.println(Arrays.toString(ch));

        int[] a=null;
        System.out.println(Arrays.toString(a));
//        a[0]=222;
//        System.out.println(Arrays.toString(a)); //NullPointerException Cannot store to int array because "a" is null
//	at Initialization.main

        int [] a3=new int[]{'f'};
        System.out.println(Arrays.toString(a3));//it will take the ASCII VALUE

        int MAX_VALUE=Integer.MAX_VALUE;
        System.out.println(MAX_VALUE);

        //Two Array in java
        int [][] array=new int[][]{{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(array));

        int[][] array1;
        array1=new int[2][3];
        array1[0][0]=1;
        array1[0][1]=2;
        array1[0][2]=3;
        array1[1][0]=4;
        array1[1][1]=5;
        array1[1][2]=6;
        System.out.println(array1.length);
        System.out.println(Arrays.deepToString(array1));


        int [][] b1=new int[3][];
        b1[0]=new int[2];
        b1[1]=new int[3];
        b1[2]=new int[4];
        b1[0][0]=1;
        b1[0][1]=2;
//        b1[0][2]=3; //Array outOfBoundsException
        b1[1][0]=4;
        b1[1][1]=5;
        b1[1][2]=6;
        b1[2][0]=7;
        b1[2][1]=8;
        b1[2][2]=9;
        b1[2][3]=10;
        System.out.println(Arrays.deepToString(b1));


        int[][] invalid =new int[8][];
        System.out.println(Arrays.deepToString(invalid));


        //Anonymous Array
        int [][] anonymous=new int[][]{{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(anonymous));


    }
}