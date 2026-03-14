// User function Template for Java
class Solution {
    public List<Integer> twoSum(int arr[], int target) {
        // Your code here
      for(int i =0;i<arr.length;i++){
          for(int j=i+1;j<arr.length;j++){
              if(arr[i]+arr[j]==target){
                List<Integer> result = new ArrayList<>();
            result.add(arr[i]);
                result.add(arr[j]);
                return result;
              }
          }
      }
      return  new ArrayList<>();
    }
}