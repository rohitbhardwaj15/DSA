class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for(String word : words){
            StringBuilder temp = new StringBuilder(word);
            result.append(temp.reverse()).append(" ");
        }
        
        return result.toString().trim();
    }
}