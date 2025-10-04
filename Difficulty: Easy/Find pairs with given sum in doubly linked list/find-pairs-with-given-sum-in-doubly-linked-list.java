/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,Node head){
        Node left = head;
        Node right = head;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        while( right.next!= null){
            right = right.next;
            
        }
        while ( left!= right && left.prev!= right){
            int sum = left.data + right.data;
            if( sum== target){
                ArrayList<Integer> val = new ArrayList<>();
                val.add(left.data);
                val.add(right.data);
                
                res.add(val);
                left = left.next;
                right = right.prev;
                

                
                
                
            }
            else if( sum < target){
                left = left.next;
                
            }
            else{
                right = right.prev;
                
            }
        }
        return res;
    
                                                                      
                                                                          
                                                                          
       
        
    }
}
