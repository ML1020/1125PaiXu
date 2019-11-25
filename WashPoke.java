import java.util.Scanner;

public class WashPoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = scanner.nextInt();//数组组数
        while (groups --> 0){
            int n  = scanner.nextInt();//数字个数的一半
            int k = scanner.nextInt();//洗牌次数
            int[] res = new int[2*n];//数据总个数
            for (int i = 0;i < 2*n;i++){
                int temp = i + 1;
                for (int j = 0;j < k;j++){
                    if (temp <= n){
                        temp = 2*temp - 1;
                    }else {
                        temp = 2 * (temp - n);
                    }
                }
                res[temp - 1] = scanner.nextInt();
                //数组中temp-1位置的数据，即洗牌后的接结果
            }
            //输出
            if (res.length > 0){
                System.out.print(res[0]);
            }
            for (int i = 1;i < 2*n;i++){
                System.out.print(" "+res[i]);
            }
            System.out.println();
        }
    }
}
