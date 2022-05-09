package com.youku.atm.cacher.test;

public class TestSorting {

    public static void main(String[] args) {

        int a[] = {12, 23, 595,435, 6, 2, 4, 543, 226, 0};

        int i, j, n, temp;
        n = a.length;

        for (j = 0; j < n; j++) {
            for (i = 0; i < n - j - 1; i++) {
                try {

                    if (a[i] > a[i + 1]) {
                        temp = a[i];
                        a[i] = a[i + 1];
                        a[i + 1] = temp;
                    }

                } catch (Exception e) {
                }
            }
        }

        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
//
//        String[] test1 = {"abc", "efg"};
//        String[] test2 = test1;
//        for (int kk = 0; kk < test2.length; kk++) {
//            System.out.println(test2[kk]);
//        }

    }

}
