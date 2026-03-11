class Solution {
    public String toggleCase(String s) {
        
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isLowerCase(c)){
                ans.append(Character.toUpperCase(c));
            }
            else{
                ans.append(Character.toLowerCase(c));
            }
        }
        
        return ans.toString();
    }
}

