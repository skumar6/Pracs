package DataStructures;

import java.util.PriorityQueue;

/**
 * Created by vineet on 7/10/17.
 */
public class MergeStrings {


    public static void main(String[] args){
        String s1 = "zingagocame@!$";
        char[] arr = s1.toCharArray();
        String str = "";
        quickSort(arr, 0 , arr.length-1);
        for(char ch : arr){
            str = str+ch;
        }
        System.out.println(str);
        String[] arr1 = {"abc", "!!!!", "njddjvjdfbdkjs", "afdfjdgjfokdjgdknck&"};

        System.out.print(merge(arr1));
    }

    public static void quickSort(char[] arr, int start, int end) {

        while (start < end) {
            int mid = (start + end) / 2;
            while (arr[start] < arr[mid])
                start++;
            while (arr[end] > arr[mid])
                end--;
            char ch = arr[end];
            arr[end] = arr[start];
            arr[start] = ch;
            start++;
            end--;
            if(start<end) {
                quickSort(arr, start, arr.length - 1);
                quickSort(arr, 0, end);
            }
        }

    }

    public static String merge(String[] arr){
        PriorityQueue<Character> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= 'a' && ch <= 'z')
                    pq.add(ch);
            }
        }
        while(!pq.isEmpty()){
            sb.append(pq.remove());
        }
        return sb.toString();
    }
}

