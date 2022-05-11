import java.util.Scanner;

public class DynamicProgramming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int n = sc.nextInt();
        if (n <= 0 || money <= 0) {
           System.out.println(0); 
        }

        good[] gs = new good[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            gs[i] = new good(v, p, q);
            if (q > 0) {
                //找到对应的主件，记录对应关系
                if (gs[q].a1 == 0) {
                    gs[q].setA1(i);
                } else {
                    gs[q].setA2(i);
                }
            }
        }

        int[][] dp = new int[n + 1] [money + 1];
        for (int i = 1; i <= n; i++) {
            int v = 0, v1 = 0, v2 = 0, v3 = 0, tempdp = 0, tempdp1 = 0, tempdp2 = 0, tempdp3 = 0;

            //只有主件
            v = gs[i].v;
            tempdp = gs[i].p * v;

            if (gs[i].a1 != 0) {
                //主件 + 附件1
                v1 = v + gs[gs[i].a1].v;
                tempdp1 = tempdp + gs[gs[i].a1].v * gs[gs[i].a1].p;
            }

            if (gs[i].a2 != 0) {
                //主件  + 附件2
                v2 = v + gs[gs[i].a2].v;
                tempdp2 = tempdp + gs[gs[i].a2].v * gs[gs[i].a2].p;
            }

            if (gs[i].a1 != 0 && gs[i].a2 != 0) {
                //主件加附件1和附件2
                v3 = v + gs[gs[i].a1].v + gs[gs[i].a2].v;
                tempdp3 = tempdp + gs[gs[i].a1].v * gs[gs[i].a1].p + gs[gs[i].a2].v * gs[gs[i].a2].p;
            }

            for (int j = 1; j <= money; j++) {
                if (gs[i].q > 0) {
                    //当物品i是附件时,相当于跳过
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= v && v != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v] + tempdp);
                    }
                    if (j >= v1 && v1 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v1] + tempdp1);
                    }
                    if (j >= v2 && v2 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v2] + tempdp2);
                    }
                    if(j >= v3 && v3 != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v3] + tempdp3);
                    }
                }
            }
        }
        System.out.print(dp[n][money]);
    }


    public static class good {
        public int v;//商品的价格
        public int p;//商品的重要度
        public int q;//是否为附件

        public int a1 = 0;//第一个附件
        public int a2 = 0;//第二个附件

        public good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }
    }
}