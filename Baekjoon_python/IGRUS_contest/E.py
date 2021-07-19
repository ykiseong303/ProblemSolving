from collections import deque
import copy 

def dfs(t, result) : 
    global visit
    global max_result
    max_result = max(result, max_result)
    for i in range(1,13) : 
        # print(i)
        if shape[t][i] == 1 and visit[i] == 0 : 
            visit[i] = 1 
            dfs(i,result+1)
            # print(visit)
            visit[i] = 0
    return max_result
        


shape = [[0]*13 for _ in range(13)]
for _ in range(12) :
    x, y= map(int, input().split())
    shape[x][y] = 1
    shape[y][x] = 1
# 연결된 정점이 3개인 정점을 찾는다 
temp = []
for i in range(1,13) : 
    count = 0
    for j in range(1,13) : 
        if shape[i][j] == 1 : 
            count += 1 
    if count == 3 : 
        temp.append(i)
# child가 3인 정점을 dfs를 돌려 깊이가 가장 큰 값을 가지는 정점을 찾는다
max_result = 0
visit = [0] * 13 
# visit[7] = 1 
# print(dfs(7,1))
# print(visit)
for t in temp : 
    print(t)
    visit[t] = 1
    dfs(t,1)
    visit = [0]*13
    print(max_result,"\n")