class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map= new HashMap<>();
      //PUTTING THE VALUE IN MAP
        for(int i =0;i<text.length();i++){
           char ch=text.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int b= map.getOrDefault('b',0);
        int a= map.getOrDefault('a',0);
        int l= map.getOrDefault('l',0)/2;
        //int l= map.getvalueOrDefault('b',0);
        int o= map.getOrDefault('o',0)/2;
        int n= map.getOrDefault('n',0);
        int max =b;
        if(max>a) max=a;
        if(max>l)max =l;
        if(max>o)max =o;
        if(max>n)max =n;
        return max;

        
    }
}