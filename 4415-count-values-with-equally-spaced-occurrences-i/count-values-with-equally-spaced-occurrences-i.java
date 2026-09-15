import java.util.*;

class Solution{
    public int countSpecialIntegers(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans=0;
        Object[] keys=map.keySet().toArray();

        for(int k=0;k<keys.length;k++){
            int x=(int)keys[k];

            if(map.get(x)==3){
                int a=-1,b=-1,c=-1;

                for(int i=0;i<nums.length;i++){
                    if(nums[i]==x){
                        if(a==-1)
                            a=i;
                        else if(b==-1)
                            b=i;
                        else
                            c=i;
                    }
                }
                if(b-a==c-b)
                    ans++;
            }
        }
        return ans;
    }
}