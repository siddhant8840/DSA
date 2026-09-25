class Solution {
    public double average(int[] arr) {
        double av;
        double max=0;
        double min =arr[0];
        double sum=0.0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
            sum+=arr[i];

        }
        sum=sum-max-min;
        return (sum/(arr.length-2));

        
        
    }
}