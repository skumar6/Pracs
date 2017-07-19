package DataStructures;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {

    public static void main(String[] args){
        int[] arr = {1,2,3};
        Arrays.sort(arr);
        List<List<Integer>> fnl = new ArrayList<List<Integer>>();

        //comSum(arr, 4, fnl, new ArrayList<>(), 0);
        //subsetsDups(arr, fnl, new ArrayList<>(), 0 );
      //  permuations(arr, fnl, new ArrayList<>());
       // permStr("abc", 0,new  StringBuilder());
        combStr("abc", new  StringBuilder(), new boolean[3]);

//        System.out.println(fnl.size());
//        for(List<Integer> l : fnl ){
//            for(int i : l)
//                System.out.print(i+" ");
//            System.out.println();
//        }

    }


    //given an array find all the combinations with sum up to target
    public static void comSum(int[] arr, int target, List<List<Integer>> fnl, List<Integer> temp,
                              int start){
        if(target < 0) return;
        else if(target == 0){
            fnl.add(new ArrayList<>(temp));
        }else{
            for(int i = start; i<arr.length; i++){
                temp.add(arr[i]);
                comSum(arr, target-arr[i], fnl, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    //returns all subsets
    public static void subsets(int[] arr, List<List<Integer>> fnl, List<Integer> temp, int start){
            fnl.add(new ArrayList<>(temp));
        for(int i = start; i<arr.length; i++){
            temp.add(arr[i]);
            subsets(arr, fnl, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void subsetsDups(int[] arr, List<List<Integer>> fnl, List<Integer> temp, int start){
        fnl.add(new ArrayList<>(temp));
        for(int i = start; i<arr.length; i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            temp.add(arr[i]);
            subsets(arr, fnl, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void permuations(int[] arr, List<List<Integer>> fnl, List<Integer> temp){

        if(temp.size()==arr.length)
            fnl.add(new ArrayList<>(temp));
        else{
        for(int i = 0; i<arr.length; i++){
            if(temp.contains(arr[i])) continue;
            temp.add(arr[i]);
            permuations(arr, fnl, temp);
            temp.remove(temp.size()-1);
        }}
    }

    //get all combination of a string
    public static void permStr(String str, int start, StringBuilder sb){
        if(start >= str.length()) return;
        for(int i =start; i<str.length(); i++){
            sb.append(str.charAt(i));
            System.out.println(sb.toString());
            permStr(str, i+1, sb);
            sb.deleteCharAt(sb.length()-1);

        }
    }

    public static void combStr(String str, StringBuilder sb, boolean[] used){
        if(sb.length()==str.length()){
            System.out.println(sb.toString());
        }else{
        for(int i =0; i<str.length(); i++){
            //System.out.println("b---"+sb.toString());
             if(used[i]) continue;
             used[i]=true;
             sb.append(str.charAt(i));
             //System.out.println("a---"+sb.toString());

             combStr(str, sb, used);

             used[i]=false;
             sb.setLength(sb.length()-1);

         }}
    }

}