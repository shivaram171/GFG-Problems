// User function Template for Java

class Solution {
    public void segregateElements(int[] arr) {
      int  n = arr.length;
     int[] temp = new int[n];
    
    

    int index =0 ;
    
    for(int i =0; i<n ;i++){
            if(arr[i]>=0){
                temp[index++] = arr[i];
                
            }
    }
    for(int i =0;i<n;i++){
        if(arr[i] <0){
            temp [index++] = arr[i];
            
        }
    }


     // Your code goes here

 
    

          for(int i =0;i<n;i++){
    arr[i]=temp[i];
}  
    }
}