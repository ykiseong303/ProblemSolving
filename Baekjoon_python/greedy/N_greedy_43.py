'''
분류 : 그리디 알고리즘
문제 : 택배 (백준 8980번)
작성일자 : 2021.03.17
'''

import sys
N, C = map(int, input().split())
M = int(input())
boxes = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(M)]
boxes.sort(key=lambda x: (x[1],x[0]))
index = 1
temp = [0 for _ in range(N)]
total = 0
answer = 0
for i in range(1,N+1) : 
    for box in boxes : 
        if box[0] == i :
            if total == C :
                temp.reverse()
                if temp.index()
            if i >= 2 : 
                total -= temp[i-1]
                answer += temp[i-1]
                print("temp",temp[i-1], "answer",answer)
                temp[i-1] = 0
             
            if box[2] <= C-total :
                temp[box[1]-1] += box[2]
                total += box[2]
            else : 
                temp[box[1]-1] = C - total
    # answer += total
    print(temp)
print(answer+temp[-1])
    # print(temp)