class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Arrays.stream(weights).max().getAsInt();
        int high=Arrays.stream(weights).sum();
        int ans=1;
        while(low<=high){
            int mid=(low+high)/2;
            if(IsItPossible(weights,days,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean IsItPossible(int weights[],int days,int mid){
        int d=1;
        int capacity=0;
        for(int i=0;i<weights.length;i++){
            if(capacity+weights[i]<=mid){
                capacity=capacity+weights[i];
            }else{
                d++;
                capacity=weights[i];
            }
            if(d>days){
                return false;
            }
        }
        return true;
    }
}