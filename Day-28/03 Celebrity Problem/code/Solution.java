import java.util.*;

class Solution {
    public int celebrity(int mat[][]) {
        // code here
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<mat.length;i++){
            stack.push(i);
        }
        while(stack.size()>1){
            int a=stack.pop();
            int b=stack.pop();
            if(mat[a][b]==1){
                stack.push(b);
            }else{
                stack.push(a);
            }
        }
        if(stack.isEmpty()){
            return -1;
        }
        int celeb=stack.pop();
        for(int i=0;i<mat.length;i++){
            if(celeb!=i){
                if(mat[celeb][i]==1 || mat[i][celeb]==0 ){
                    return -1;
                }
            }
            
        }
        return celeb;
    }
}

