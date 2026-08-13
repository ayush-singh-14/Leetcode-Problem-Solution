class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int n= matrix.length;
       int m=matrix[0].length;

       int left=0, right=n*m-1;

       while(left<=right){

        int mid=left+(right-left)/2;
        int row=mid/m;
        int col=mid%m;
        int midVal=matrix[row][col];

        if(midVal==target){
            return true;
        }
        else if(midVal<target){
            left= mid+1;
        }
        else{
            right=mid-1;
        }
       }
       return false;
    }
}