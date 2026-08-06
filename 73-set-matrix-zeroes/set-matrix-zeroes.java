class Solution {
 public void setZeroes(int[][] a){int m=a.length,n=a[0].length,r=1,c=1;
 for(int i=0;i<m;i++)for(int j=0;j<n;j++)if(a[i][j]==0){if(i==0)r=0;if(j==0)c=0;a[i][0]=a[0][j]=0;}
 for(int i=1;i<m;i++)for(int j=1;j<n;j++)if(a[i][0]==0||a[0][j]==0)a[i][j]=0;
 for(int j=0;j<n;j++)if(r==0)a[0][j]=0;for(int i=0;i<m;i++)if(c==0)a[i][0]=0;}}