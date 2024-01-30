import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //1D Array in Java
        int[] arr = new int[6];
        arr[3] = 333;
        arr[4] = 444;
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
        int len=arr.length;
        for(int i=0; i<len; i++) {
            System.out.println(arr[i]);
        }
        //enhanced for loop
        for(int i : arr) {
            System.out.println(i);
        }


        //2D Array in Java
        int[][] arr1 = new int[4][4];
        System.out.println(arr1.length);
        System.out.println(arr1[0].length);
        System.out.println(Arrays.deepToString(arr1));

        for(int i=0;i<arr1.length;i++){
            System.out.println(i);
            for(int j=0;j<arr1[0].length;i++){
                    System.out.println("arr1["+i+"]["+j+"]="+arr1[i][j]);
            }
        }


        //examples more
        int[][] arr2 = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(arr2));

        int[][] arr3 = new int[3][];
        arr3[0] = new int[3];
        arr3[1] = new int[4];
        arr3[2] = new int[5];
        System.out.println(Arrays.deepToString(arr3));
        System.out.println(arr3.length);
        System.out.println(arr3[0].length);

    }
}