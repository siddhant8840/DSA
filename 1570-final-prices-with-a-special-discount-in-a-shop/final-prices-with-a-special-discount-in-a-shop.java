class Solution {
    public int[] finalPrices(int[] p) {
        int n =p.length;
        int k=0;
        int arr[]=new int [n];
        for(int i=0;i<n;i++){
            int j=i+1;
            while(j<n&&p[j]>p[i])
                j++;
            if(j<n) arr[i] = p[i] - p[j];
            else 
            arr[i]=p[i];
                
            
            
        }
        return arr;
        
    }
}