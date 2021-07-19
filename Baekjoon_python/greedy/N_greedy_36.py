'''
분류 : 그리디 알고리즘
문제 : 크게 만들기 (백준 2812번)
작성일자 : 2021.03.14
'''

# 목적 : N자리 숫자가 입력될 때, K만큼 빼서 가장 큰 수 만들기
# 접근 : 최대힙, 스택을 사용해서 구현
## 시간초과가 뜨는데 왜 그런지 모르겠음

import heapq
import sys

N, K = map(int, input().split())
num = sys.stdin.readline().rstrip()

temp = []
for n in num : 
    temp.append(int(n))
temp.sort()
result = []
for i in range(N-K) : 
    result.append(temp.pop())
    #result.append(temp.pop() *pow(10,(N-K-i-1)))
#print(result)
for j in range(len(temp)) : 
    print(result[j],end='')
# print(result)

'''
# 최대힙을 구현하기 위한 리스트 생성
myQue = []
# 입력받은 값을 최대힙으로 구현
for i in range(N) : 
    heapq.heappush(myQue, -int(num[i]))
result = 0
for i in range(N-K) : 
    result += heapq.heappop(myQue) * -1*pow(10,(N-K-i-1))
print(result)
    # result.append(heapq.heappop(myQue) * -1*pow(10,(N-K-i-1)))
# print(sum(result))
# total = 0
# for i in range(len(result)) : 
#     total += result[i] * 10^(len(result)-i-1)
#     print(total)
'''