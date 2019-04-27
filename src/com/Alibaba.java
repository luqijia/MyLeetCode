package com;

import java.util.Scanner;


public class Alibaba {
	
	
	static String calculate(int m, int k) {
		int[] arr =new int[m];
		for (int i = 1; i < m+1; i++) {
			arr[i-1] = bianhao(i);
		}
		int num = arr[m-1];  //第m个的编号
		int[] a = new int[m];
		for (int i = 0; i < arr.length; i++) {
			a[i]=reverse(arr[i]);
		}
		quickSort(a);
		int pig = 1;
		for (int i = 0; i < arr.length; i++) {
			if (reverse(arr[i])==a[m-k]) {
				pig=i+1;
				break;
			}
		}
		return String.valueOf(num)+",,"+String.valueOf(pig);
    }
	static int bianhao(int m) {
		if(m==1) {
			return 2;
		}else if (m==2) {
			return 3;
		}else if (m==3) {
			return 4;
		}else {
			return bianhao(m-2)+bianhao(m-3);
		}
	}
	
	public static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}
	
	private static int CUTOFF = 5;

	/**
	 * 快速排序(驱动程序)
	 * 
	 * @param arr
	 */
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	/**
	 * 执行三数中值分割法的程序
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	private static int median3(int[] arr, int left, int right) {
		int center = (left + right) / 2;
		if (arr[center] < arr[left]) {
			swapReferences(arr, left, center);
		}
		if (arr[right] < arr[left]) {
			swapReferences(arr, left, right);
		}
		if (arr[right] < arr[center]) {
			swapReferences(arr, center, right);
		}

		// 将枢轴置于right-1的位置
		swapReferences(arr, center, right - 1);
		return arr[right - 1];
	}


	/**
	 * 元素交换
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	private static void swapReferences(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}

	private static void quickSort(int[] arr, int left, int right) {
		if (left + CUTOFF <= right) {
			int pivot = median3(arr, left, right);
			int i = left;
			int j = right - 1;
			for (;;) {
				while (arr[++i] < pivot) {
				}
				while (arr[--j] > pivot) {
				}
				if (i < j) {
					swapReferences(arr, i, j);
				} else {
					break;
				}
			}
			swapReferences(arr, i, right - 1); // 恢复枢轴
			quickSort(arr, left, i - 1); // 排序小元素
			quickSort(arr, i + 1, right); // 排序大元素
		} else {
			insertionSort(arr, left, right); // 在子数组上执行插入排序
		}
	}

	private static void insertionSort( int[] a, int left, int right )
    {
        for( int p = left + 1; p <= right; p++ )
        {
            int tmp = a[ p ];
            int j;

            for( j = p; j > left && tmp<a[ j - 1 ]; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));
    }
	
}
