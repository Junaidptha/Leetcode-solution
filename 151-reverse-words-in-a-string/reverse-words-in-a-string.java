class Solution {
    public String reverseWords(String s) {
        char arr[] = s.toCharArray();
        reverse(arr, 0, arr.length - 1);

        int start = 0;

        for (int end = 0; end <= arr.length; end++) {
            if (end == arr.length || arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
        }
        
        int i = 0, j = 0;
        while (j < arr.length) {
            // skip spaces
            while (j < arr.length && arr[j] == ' ') {
                j++;
            }
            // copy characters
            while (j < arr.length && arr[j] != ' ') {
                arr[i++] = arr[j++];
            }
            // skip extra spaces
            while (j < arr.length && arr[j] == ' ') {
                j++;
            }
            // add one space
            if (j < arr.length) {
                arr[i++] = ' ';
            }
        }
        return new String(arr, 0, i);
    }

    public void reverse(char arr[], int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}