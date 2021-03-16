static void miniMaxSum(int[]arr){

        //Solution 1
        int minValue=Arrays.stream(arr).min().getAsInt();
        int maxValue=Arrays.stream(arr).max().getAsInt();
        long minSum=Arrays.stream(arr).filter(value->value!=maxValue)
        .reduce(0,Integer::sum);
        long maxSum=Arrays.stream(arr).filter(value->value!=minValue)
        .reduce(0,Integer::sum);
        System.out.println("We would print "+minSum+" "+maxSum);
}