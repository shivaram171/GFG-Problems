
class Solution {
    boolean twoSum(int arr[], int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}




// class Solution{
//     bolean twoSum(int arr[], int target){
        
        
        
//         HashMap <Integer> map = new HashMap
//         for(int i =0;i<arr.length;i++){
//             int req = targe-arr[]
//         }
//     }
    
    
// }