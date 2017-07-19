import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by vineet on 6/21/17.
 */
public class Uptake {
    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
//        int[] pat = {3, 5, 6};
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);
//        boolean[][] vis = new boolean[arr.length][arr[0].length];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                //if(helper(arr, i , j, 0, pat, vis))
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                if (helper(arr, i, j, 0, pat, vis)) {
//                    System.out.print("true");
//
//
//                }
//
//            }
//            System.out.print("false");
//
//        }

        List<List<Integer>> fnl = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        helper1(4, fnl, temp, 4);

//
//        for(List<Integer> l : fnl){
//
//            for(int i : l)
//                System.out.print(i +" ");
//            System.out.println();


        //permutations("1123", 0);
        String str = "abc";
        //System.out.println("-----"+str.substring(0,1));
        combinations(str, 0, new StringBuilder());



    }

    public static boolean helper(int[][] nums, int i, int j, int index, int[] pat, boolean[][] visited) {

        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || index >= pat.length
                || nums[i][j] != pat[index] || visited[i][j])
            return false;
        visited[i][j]=true;
        System.out.println("Entering for: "+nums[i][j]);
        if(nums[i][j] == pat[index]) return true;
        if(helper(nums, i+1,j, index+1, pat, visited) ||
        helper(nums, i,j+1, index+1, pat, visited) ||
        helper(nums, i-1,j, index+1, pat, visited) ||
        helper(nums, i,j-1, index+1, pat, visited))
                return true;
        visited[i][j]=false;
        return false;


    }

    public static void helper1(int n, List<List<Integer>> fnl,  List<Integer> temp, int target){
        if(target == 0) {
            ArrayList<Integer> curr = new ArrayList<Integer>(temp);
            fnl.add(curr);
            return;
        }



            for(int i =1; i<=n; i++){
                if(target < i)
                    return ;
                temp.add(i);

                helper1(n, fnl, temp, target-i);
                temp.remove(temp.size()-1);
            }


    }

    public static void permutations(String str, int start){
        if(start == str.length()){
            System.out.println(str);
            return;
        }
        for(int i = start; i<str.length(); i++){
            //swap i with index, index++
           char[] arr = str.toCharArray();
           char temp = arr[start];
            arr[start] = arr[i];
            arr[i]=temp;
            str = String.valueOf(arr);
            permutations(str, start+1);
        }

    }

    public static void combinations(String str, int start, StringBuilder sb){
        if(str.length()<=1)
            return;
        for(int i = start; i<str.length(); i++){
            sb.append(str.charAt(i));
            System.out.println(sb);

            combinations(str, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
