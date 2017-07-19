package DataStructures;

import java.util.ArrayList;

/**
 * Created by vineet on 7/10/17.
 */
public class TwoSum {

    public static void main(String[] args){
        int[] arr = {0,1,2,3,4,5,6,6,7};
        ArrayList<int[]> lst = new ArrayList<>();
        helper(arr,  6, lst);

        for(int[] r : lst){
            System.out.println(r[0]+" : "+r[1]);
        }
    }



//return arrayList of Array
    //given an array of numbers returns all unique pairs which return that sum.
public static void helper(int[] nums, int target, ArrayList<int[]> fnl){
    int start =0, res = 0, end = nums.length-1;


    while(start < end){
        int[] temp = new int[2];
        if(nums[start] + nums[end] > target)
            end--;
        else if(nums[start] + nums[end] < target)
            start++;
        else{
            System.out.println("adding: " +nums[start]+" + "+nums[end]);
            temp[0]=nums[start];
            temp[1]=nums[end];
            fnl.add(temp);
            start++;
           // end--;
        }
    }
}

}
