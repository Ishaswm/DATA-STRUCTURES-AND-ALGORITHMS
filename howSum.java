    public static int[] howSum(int ts, int nums[]) {
        if (ts == 0) {
            return new int[0];
        }
        if (ts < 0) {
            return null;
        }
        for (int i=0; i<nums.length; i++){
            int remainder = ts - nums[i];
            int[] remainderResult = howSum(remainder, nums);
            if (remainderResult != null){
                int result[] = new int[remainderResult.length + 1];

                for (int j=0; j<remainderResult.length; j++){
                    result[j] = remainderResult[j];
                }
                result[remainderResult.length] = nums[i];
                return result;
            }
        }
        return null;
    }
    public static int[] howSumMemo(int ts, int nums[], Map<Integer, int[]> memo) {

        if (ts == 0) {
            return new int[0];
        }
        if (ts < 0) {
            return null;
        }
        if (memo.containsKey(ts)){
            return memo.get(ts);
        }
        for (int i=0; i<nums.length; i++){
            int remainder = ts - nums[i];
            int[] remainderResult = howSumMemo(remainder, nums, memo);
            if (remainderResult != null){
                int result[] = new int[remainderResult.length + 1];

                for (int j=0; j<remainderResult.length; j++){
                    result[j] = remainderResult[j];
                }
                result[remainderResult.length] = nums[i];
                memo.put(ts, result);
                return result;
            }
        }
        memo.put(ts, null);
        return null;
    }
