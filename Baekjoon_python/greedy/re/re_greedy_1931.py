'''
분류 : 그리디 알고리즘 (재풀이)
문제 : 회의실 배정 (백준 1931번)
작성일자 : 2021.03.25
'''

# 접근 : 회의의 시작시간과 끝나는 시간을 기준으로 각각 정렬하고 
#       기준 값에 대해 시작시간이 크거나 같은 값만 찾는다

import sys
N = int(input())
lst = []
for _ in range(N) : 
    lst.append(list(map(int, sys.stdin.readline().rstrip().split())))
lst.sort(key=lambda x:(x[1],x[0]))
start = lst[0][1]
count = 1 
for i in range(1,N) : 
    if start <= lst[i][0] : 
        start = lst[i][1]
        count += 1
print(count)