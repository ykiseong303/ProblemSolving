'''
분류 : 그리디 알고리즘
문제 : 빵집 (백준, 3109번)
작성일자 : 2021.03.11
'''

# 건물을 피해 파이프 연결하기
## 목적 : 최대로 연결할 수 있는 파이프의 수 출력 
## 접근 : (아마도?) 1자 방향이 최우선, V자 방향이 2순위로 진행

import sys
R, C = map(int, input().split())
map = []
a=[]
for _ in range(R) : 
    a = list(sys.stdin.readline().rstrip())
    map.append(a)
#print(map)
x,y=0,0
count = 0
n = 0
while n < R :
    if map[x][y] != 'x' : 
        map[x][y] = 'x' 
        # 오른쪽 전진
        # 위, 아래 중 어디로 갈 것인지 결정
        y = y+1
        print("x no",x,y)
    else :#map[x][y] == 'X' : 
        x = x+1
        if x == R : 
            x = 0
            y = 0 
            n += 1
        else : 
            print("x yes",x,y)
            if map[x][y] != 'x' : 
                map[x][y] = 'x'
                if y <  C-1 and x>0 and map[x-1][y+1] !='x' : 
                    x = x-1
                    y = y+1 
                    print("side",x,y)
                else : 
                    y = y+1
                    print("no side",x,y)
            # else : 
            #     x = x+1
    if y == C: 
        print("y==c")
        count += 1
        x = 0
        y = 0
        n += 1


    for m in map : 
        print(*m)
    print("\n")
print(count)

'''
import sys
R, C = map(int, input().split())
map = []
a=[]
for _ in range(R) : 
    a = list(sys.stdin.readline().rstrip())
    map.append(a)
#print(map)
x,y=0,0
count = 0
n = 0
while n < R :
    if map[x][y] != 'x' : 
        map[x][y] = 'x' 
        # 오른쪽 전진
        # 위, 아래 중 어디로 갈 것인지 결정
        y = y+1
        # print("x no",x,y)
    else :#map[x][y] == 'X' : 
        x = x+1
        if x == R : 
            x = 0
            y = 0 
            n += 1
        else : 
            # print("x yes",x,y)
            if map[x][y] != 'x' : 
                map[x][y] = 'x'
                if y <  C-1 and x>0 and map[x-1][y+1] !='x' : 
                    x = x-1
                    y = y+1 
                    # print("side",x,y)
                else : 
                    y = y+1
                    # print("no side",x,y)
            # else : 
            #     x = x+1
    if y == C: 
        # print("y==c")
        count += 1
        x = 0
        y = 0
        n += 1


        for m in map : 
            print(*m)
        print("\n")
print(count)

    
'''

    
