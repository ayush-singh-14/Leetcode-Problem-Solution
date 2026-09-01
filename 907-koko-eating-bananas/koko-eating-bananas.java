class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Arrays.stream(piles).max().getAsInt();
        int ans=0;
        while(low<=high){
            int mid=(high+low)/2;
            if(IsItPossible(piles,h,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean IsItPossible(int piles[],int h,int mid){
        long hour=0;
        for(int pile:piles){
            hour+=(pile+mid-1)/mid;
        }
        return hour<=h;
    }
}