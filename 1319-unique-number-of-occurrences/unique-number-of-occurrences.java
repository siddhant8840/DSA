class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n =arr.length;
        HashMap<Integer,Integer> map =new HashMap<>();
        for (int i=0;i<n;i++){
           if(!map.containsKey(arr[i])) map.put(arr[i],0);
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        HashSet<Integer> set =new HashSet<>();
        //int freq;
        for (int freq:map.values()) set.add(freq);

      return( map.size()==set.size());
    }
    
    
}