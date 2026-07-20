class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set =new HashSet<>();
        for(int n:nums) set.add(n);
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)) li.add(i);
        }
        return li;
    }
}