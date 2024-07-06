package com.ohgiraffers.section01.aop;

class Solution {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 100, 99, 98};
        int k = 4;

        int answer[] = solution(arr, k);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr, int k) {

        if (k % 2 == 1) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] *= k;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += k;
            }
        }
        return arr;
    }
}