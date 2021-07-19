'''
분류 : 그리디 알고리즘 (재풀이)
문제 : 강의실 배정 (백준 11000번)
작성일자 : 2021.03.22
'''
# 목적 : 수업을 모두 진행할 수 있는 최소의 강의실 수를 출력한다
# 접근 : 우선순위큐를 이용하고 끝나는 시간이 가장 짧은 강의부터 수업을 이어갈 수 있도록한다
#       그냥 큐를 사용해도 될것 같은데, 왜 꼭 최소힙이어만 가능한지 반례를 모르겠음 
#       N이 최대 20만 까지이므로, 시간초과 (입력과 반복사이클)에 유의한다

import heapq
import sys

N = int(input())
time = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
# 시작시간을 기준으로 정렬한다
time.sort(key=lambda x : x[0])
# 큐에 맨 처음 강의시간의 끝나는 시간을 넣는다
queue = []
heapq.heappush(queue, time[0][1])

for i in range(1,N) : 
    if time[i][0] >= queue[0] : 
        heapq.heappop(queue)
    heapq.heappush(queue, time[i][1])
print(len(queue))


