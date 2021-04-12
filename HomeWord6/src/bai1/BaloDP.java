package bai1;

import java.util.Scanner;

public class BaloDP
{
    static int max(int a, int b)
    {
        if(a > b)
        {
            return a;
        }
        return b;
    }
    static int knapSack(int weight, int itemWeight[], int value[], int n)
    {
        int i, w;
        int [][]arr = new int[n+1][weight + 1];

        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= weight; w++)
            {
                if (i == 0 || w == 0)
                    arr[i][w] = 0;
                else if (itemWeight[i - 1] <= w)
                    arr[i][w] = max(value[i - 1] + arr[i - 1][w-itemWeight[i - 1]],  arr[i - 1][w]);
                else
                    arr[i][w] = arr[i - 1][w];
            }
        }

        return arr[n][weight];
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong do vat ");
        int n = sc.nextInt();
        System.out.println("Nhap can nang cua cac do vat ");
        int []itemWeight = new int[n];
        for(int i = 0; i < n; i++)
            itemWeight[i] = sc.nextInt();

        System.out.println("Nhap gia tri cua cac do vat ");
        int []value = new int[n];
        for(int i = 0; i < n; i++)
            value[i] = sc.nextInt();

        System.out.println("Nhap suc chua cua balo ");
        int weight = sc.nextInt();

        System.out.println("Balo co the chua duoc gia tri lon nhat la: " + knapSack(weight, itemWeight, value, n));
        sc.close();
    }
}