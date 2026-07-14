class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count =0;
        for(int i=0;i<=arr.length-k;i++) {
            int sum=0;
            for(int j=0;j<k;j++){
               // int sum=0;
                sum+=arr[i+j];

            }
             sum=sum/k;
            if (sum>=threshold) count++;


        }
        return count;

        
    }
}