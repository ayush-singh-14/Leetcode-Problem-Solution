class Solution:
    def checkDivisibility(self, n: int) -> bool:
        m=n
        s=0
        prod=1
        while n >0:
            rem=n%10
            s += rem
            prod *= rem
            n = n//10
        return m%(s+prod) ==0