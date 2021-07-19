'''
분류 : 그리디 알고리즘
문제 : 공주님의 정원 (백준, 2457번)
작성일자 : 2021.03.19
'''
import sys
N = int(input())
flower = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
flower.sort(key=lambda x: (x[2],x[3],x[0],x[1]))
for f in flower : 
    if f[0] <= 3 and f[2] >= 11 : 