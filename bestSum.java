public static int[] bestSum(int ts, int nums[]) {
        if (ts == 0){
            return new int[0];
        }
        if (ts < 0){
            return null;
        }
        int shortestResult[] = null;

        for (int i=0; i<nums.length; i++){
            int remainder = ts - nums[i];
            int[] remainderResult = bestSum(remainder, nums);
            if (remainderResult != null){
                int result[] = new int[remainderResult.length + 1];

                for (int j=0; j<remainderResult.length; j++){
                    result[j] = remainderResult[j];
                }
                result[remainderResult.length] = nums[i]; // added all the combinations but also need to add the current number too! thats literally the parent node 
                if (shortestResult == null || shortestResult.length > result.length) {
                    shortestResult = result;
                }
            }

        }
        return shortestResult;

    }
