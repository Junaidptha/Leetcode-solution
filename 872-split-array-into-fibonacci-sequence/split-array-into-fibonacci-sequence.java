class Solution {
    List<Integer> ans = new ArrayList<>();
    boolean found = false;

    public void helper(String num,List<Integer> temp, int idx){
        if (found) return;
        if (idx == num.length()) {
            if (temp.size() >= 3) {
                ans = new ArrayList<>(temp);
                found = true;
            }
            return;
        }

        long curr = 0;
        for (int i = idx; i < num.length(); i++) {

            if (i > idx && num.charAt(idx) == '0') break;
            curr = curr * 10 + (num.charAt(i) - '0');
            if (curr > Integer.MAX_VALUE) break;
            
            int size = temp.size();
            if (size >= 2) {
                long sum = (long) temp.get(size - 1) + temp.get(size - 2);

                if (curr < sum) continue;
                if (curr > sum) break;
            }
            temp.add((int) curr);
            helper(num, temp, i + 1);
            temp.remove(temp.size() - 1);

        }
    }
    public List<Integer> splitIntoFibonacci(String num) {
        helper(num, new ArrayList<>(), 0);
        return ans;
    }
}