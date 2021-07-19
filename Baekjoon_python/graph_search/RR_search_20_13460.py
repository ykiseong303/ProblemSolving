'''
분류 : DFS & BFS
문제 : 구슬 탈출2 (백준 13460)
작성일자 : 2021.04.06
'''

# 목적 : 최소 몇번의 움직이므로 빨간구슬을 구멍으로 넣을 수 있는지 출력
# 접근 : 간선의 비용이 모두 1로 같으므로 bfs를 사용핟다(dfs는 최단거리임을 보장할 수 x)
#       문제 풀이를 위해 고려해야할 사항 
#       1. 구슬의 움직임
#       2. 동시에 끝나는 경우
#       3. 방문처리
#       4. 빨간구슬과 파란구슬의 위치가 같은 경우

import sys 
from collections import deque 

def move(x,y,dx,dy) : 
    cnt = 0
    # 벽을 만나거나 구멍을 만날때까지 이동
    while 1 : 
        if shape[x+dx][y+dy] == '#' or shape[x][y] == 'O' :
            break
        x += dx
        y += dy
        cnt += 1 
    return x, y, cnt

def bfs(q) : 
    while q : 
        # 현재 각 구슬의 좌표를 뽑는다
        rx,ry,bx,by,depth = q.popleft()
        if depth > 10 : 
            return -1
        for i in range(4) : 
            r_nx,r_ny,r_cnt = move(rx,ry,dx[i],dy[i])
            b_nx,b_ny,b_cnt = move(bx,by,dx[i],dy[i])

            if shape[b_nx][b_ny] == 'O' : 
                continue 
            if shape[r_nx][r_ny] == 'O' : 
                return depth
            if r_nx == b_nx and r_ny == b_ny : 
                if r_cnt > b_cnt : 
                    r_nx -= dx[i]
                    r_ny -= dy[i]
                else : 
                    b_nx -= dx[i]
                    b_ny -= dy[i]
            if visit[r_nx][r_ny][b_nx][b_ny] == False : 
                visit[r_nx][r_ny][b_nx][b_ny] = True 
                q.append((r_nx,r_ny,b_nx,b_ny,depth+1))
    return -1 
 

N, M = map(int, input().split())
shape = [list(sys.stdin.readline().strip()) for _ in range(N)]
# 방문을처리를 위한 리스트 생성 
visit = [[[[False] * M for _ in range(N)]for _ in range(M)]for _ in range(N)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
q = deque() 
# R과 B의 좌표를 큐에 삽입
for i in range(N) : 
    for j in range(M) : 
        if shape[i][j] == 'R' : 
            rx = i;ry = j
        if shape[i][j] == 'B' : 
            bx = i;by = j
q.append((rx,ry,bx,by,1))
# 각 구슬의 처음 위치를 방문처리

visit[rx][ry][bx][by] = True 
print(bfs(q))