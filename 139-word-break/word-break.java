class Solution {
 public boolean wordBreak(String s,List<String>w) {
  boolean[]d=new boolean[s.length()+1];d[0]=true;for(int i=0;i<s.length();i++)if(d[i])for(String x:w)if(s.startsWith(x,i))d[i+x.length()]=true;return d[s.length()];
 }
}