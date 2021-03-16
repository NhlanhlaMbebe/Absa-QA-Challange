long minSum=Arrays.stream(arr).filter(value->value!=maxValue)
        .reduce(0,Integer::sum);
long maxSum=Arrays.stream(arr).filter(value->value!=minValue)
        .reduce(0,Integer::sum);