from collections import deque

class Solution:
    def findSafeWalk(self, grid: list[list[int]], health: int) -> bool:
        m, n = len(grid), len(grid[0])
        
        # This grid stores the maximum health we have left at each cell.
        # Initialize with -1 to show we haven't visited any cell yet.
        max_health = [[-1] * n for _ in range(m)]
        
        # Initial setup at the starting cell (0, 0)
        start_health = health - grid[0][0]
        if start_health <= 0:
            return False
            
        # Queue format: (row, col, current_health)
        queue = deque([(0, 0, start_health)])
        max_health[0][0] = start_health
        
        # Up, down, left, right movements
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        
        while queue:
            r, c, h = queue.popleft()
            
            # If we reached the end with health > 0, return True
            if r == m - 1 and c == n - 1:
                return True
                
            # If we already found a path to this cell that gave us MORE health,
            # skip processing this older queue item.
            if h < max_health[r][c]:
                continue
                
            # Check all 4 possible movements
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                
                # Make sure the next cell is inside the grid boundaries
                if 0 <= nr < m and 0 <= nc < n:
                    next_health = h - grid[nr][nc]
                    
                    # If health remains positive and this path gives us 
                    # strictly MORE health than any previous visit, take it.
                    if next_health > 0 and next_health > max_health[nr][nc]:
                        max_health[nr][nc] = next_health
                        queue.append((nr, nc, next_health))
                        
        return False
