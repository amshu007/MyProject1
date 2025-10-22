package com.example.rating.test1;

public class PairSum {
    public static void main(String[] args) {

        int[] arr = new int[]{0,-1,2,-3,1};
        int  target = -2;

        for(int i =0; i< arr.length; i++){

            for(int j = i+1; j < arr.length; j++){
                if(arr[i]+arr[j]==target){
                    System.out.println(arr[i]+","+arr[j]);
                    break;
                }
            }

        }
    }
}
