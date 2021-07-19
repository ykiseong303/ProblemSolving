'''
분류 : 그리디 알고리즘
문제 : 행렬 (백준 1080번)
작성일자 : 2021.03.04
'''

'''
# 다른 풀이 1 
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
A = [input().rstrip() for _ in range(n)]
B = [input().rstrip() for _ in range(n)]
AtoB = [[x == y for x, y in zip(arow, brow)] for arow, brow in zip(A, B)]

def flip(i, j):
    for row in AtoB[i:i+3]:
        row[j:j+3] = [not val for val in row[j:j+3]]

def can_change():
    ans = 0
    for i in range(n-2):
        for j in range(m-2):
            if not AtoB[i][j]:
                flip(i, j)
                ans += 1
    if all(all(row) for row in AtoB):
        return ans
    return -1

print(can_change())
'''