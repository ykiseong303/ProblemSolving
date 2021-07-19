'''
분류 : 그리디 알고리즘 (재풀이)
문제 : 통나무 건너뛰기 (백준 11497번)
작성일자 : 2021.03.25
'''

# 여기서는 덱을 사용했지만
# 그냥 정렬 후, index가 2만큼 차이나는 값과 계산을 하면
# 더 편하게 구할 수 있음

import sys 
from collections import deque

T = int(input())
for _ in range(T) : 
    N = int(input())
    lst = sorted(list(map(int, sys.stdin.readline().rstrip().split())), reverse= True)
    max_val = max(lst)
    queue = deque([max_val])
    for i in range(1,N) : 
        if not i%2 : 
            queue.append((lst[i]))
        else : 
            queue.appendleft((lst[i]))
    list(queue)
    # print(queue)
    start = abs(queue[0] - queue[1])
    for i in range(1,N) :
        if i == N-1 : 
            start = max(start, abs(queue[0]-queue[-1])) 
            break
        if start < abs(queue[i] - queue[i+1]) : 
            start = abs(queue[i] - queue[i+1])
    print(start)