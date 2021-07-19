'''
분류 : 그리디 알고리즘
문제 : 저울 (백준, 2437번)
작성일자 : 2021.03.06
'''
import sys
N = int(input())
weight = list(map(int, sys.stdin.readline().split()))
weight.sort(reverse=True)

target = 1 
total = 0 
temp = 0 
while 1 : 
    temp = target
    for one in weight : 
        if temp >= one : 
            temp -= one
            #print(temp)
    if temp != 0 : 
        #print(temp)
        break
    target += 1 
print(target)