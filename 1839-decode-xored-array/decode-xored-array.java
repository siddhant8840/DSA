class Solution {
    
    public int[] decode(int[] en, int first) {
    int l =en.length;
    int [] arr=new int[l+1];
    int j=1;
    arr[0]=first;
    for(int i=0;i<l;i++){
        arr[i+1]=arr[i]^en[i];


    }    
    return arr;
    }
}