/**
 * @param {number[][]} mat
 * @returns {string[]}
 */
class Solution {
    ratInMaze(maze) {
        // code here
        const c = maze.length;
        const r = maze[0].length;
        
        const visited = [];
        for(let i=0; i<c; i++){
            const row = [];
            for(let j=0; j<r; j++) row.push(0);
            visited.push(row);
        }
        
        const ans = [];
        
        this.solve(maze,visited,ans,r,c,0,0,"");
        
        return ans.sort();
    }
    
    
    solve(maze,visited,ans,r,c,y,x,path){
        if(y == r-1 && x == c-1) return ans.push(path);
        
        if(y < 0 || y == r || x < 0 || x == c) return;
        
        if(maze[y][x] == 0) return;
        
        if(visited[y][x] == 1) return;
        
        visited[y][x] = 1;
        
        this.solve(maze,visited,ans,r,c, y, x+1, path+"R");
        this.solve(maze,visited,ans,r,c, y, x-1, path+"L");
        this.solve(maze,visited,ans,r,c, y-1, x, path+"U");
        this.solve(maze,visited,ans,r,c, y+1, x, path+"D");
        
        visited[y][x] = 0;
    }
}