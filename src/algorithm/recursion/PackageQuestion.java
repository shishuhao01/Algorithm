package algorithm.recursion;

public class PackageQuestion {
    //背包问题
    public static void main(String[] args) {
        int[] weight = {1,2,3,4,5,6};
        int bag = 10;
        int[] values = {10,2,3,4,5,6};
        System.out.println(process(weight,values,bag,0,0,0));

    }

    /**
     *
     * @param weights  重量数组
     * @param values   价值数组
     * @param bag      背包重量
     * @param i        当前i
     * @param alreadyWeights  已经在背包的重量
     * @param alreadyValues   已经在背包的价值
     * @return
     */
    public static int process (int[] weights, int[] values, int bag, int i, int alreadyWeights, int alreadyValues) {
        if (alreadyWeights > bag) {
            return 0;
        }
        if (i == weights.length) {
            return alreadyValues;
        }
        return Math.max(process(weights,values,bag,i+1,alreadyWeights + weights[i],alreadyValues + values[i]) //要此时的这个物品，将价值和重量都增加,进入下一个物品
                , process(weights,values,bag,i+1,alreadyWeights,alreadyValues)); //不要这个物品

        //取两个之中较大值

    }
}
