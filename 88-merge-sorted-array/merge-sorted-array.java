class Solution {
    public void merge(int[] n1, int m, int[] n2, int n) {
        int arr[]=new int[m+n];
        int i=0,j=0;
        int k=0;
        //int ma=Math.max(m,n);
        while(i<m && j<n){
         if(n1[i]<=n2[j])
                arr[k++]=n1[i++];
               // i++;
               else arr[k++]=n2[j++];
        }
        while(i<m)arr[k++]=n1[i++];
        while(j<n)arr[k++]=n2[j++];
        for(int x=0;x<m+n;x++){
            n1[x]=arr[x];
        }
       
    }
}