class Solution {
    public double myPow(double x, int n) {
        int sign = 1;
        if(n < 0) {
            sign = -1;
            n = (-1) * n;
        }
        double ans = 0;

        ans = helper(x, n);
        if(sign == -1){
            return 1/ans;
        }
        return ans;


    }
    public double helper(double x, int n){
        if(n == 0) return 1;

        double half = helper(x, n /2);

        if(n % 2 == 0) return half * half;
        else return half * half * x; 
    }
}