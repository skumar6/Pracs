package DataStructures;

/**
 * Created by vineet on 7/11/17.
 */
public class JsonParser {

    public static void main(String[] args){
        int[] arr = {1,3,1,3,2,1};
        System.out.print(countStrokes(arr));
    }

    public static int countStrokes(int[] arr) {
        int level = 0;
        int count = 0;
        for (int i : arr) {
            if (i > level)
                count = count + (i - level);
            level = i;
        }
        return count;

    }
}
