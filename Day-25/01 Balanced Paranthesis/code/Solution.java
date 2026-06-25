class Solution {
    public boolean isValid(String str) {
        int n = str.length();
        Stack<Character> stk = new Stack<>();// need to track the currently opened parentheses

        
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);

            if(!startsWithOpenings(s)){
                return false;
            }else if(isOpening(ch)){
                stk.push(ch);
            }else if(!isCorrespondingClosing(stk,ch)){
                return false;
            }else if(isCorrespondingClosing(stk,ch)){
                stk.pop();
            }
        }

        return stk.size() == 0;
    }

    boolean startsWithOpenings(String s){
        char ch = s.chartAt(0)
        return  ch == '{' || ch == '(' || ch == '[';
    }

    boolean isOpening(char ch){
        return  ch == '{' || ch == '(' || ch == '[';
    }

    boolean isCorrespondingClosing(Stack<Character> stk, char ch){
        // Good for onle 10 entries
        Map<Character, Character> pairs = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );

        return stk.peek() == pairs.get(ch);
    }
}