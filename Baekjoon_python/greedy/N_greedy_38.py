'''
분류 : 그리디 알고리즘
문제 : UCPC는 무엇의 약자일까 (백준, 15904)
작성일자 : 2021.03.14
'''

import sys

lst = sys.stdin.readline().rstrip()
result = []
ucpc = ['U','C','P','C']
for l in lst : 
    # print(l)
    if ord(l) < 97 and ord(l)!=32: 
        result.append(l)
        #print(result)
answer = "".join(result)

'''
if answer == 'UCPC' : 
    print("I love UCPC")
else : 
    print("I hate UCPC")
'''
'''
while 1 : 
    print(ord('a'))
    lst = sys.stdin.readline().rstrip()
    result = []
    for l in lst : 
        # print(l)
        if ord(l) < 97 and ord(l)!=32: 
            result.append(l)
            print(result)
    answer = "".join(result)
    if answer == 'UCPC' : 
        print("I love UCPC")
    else : 
        print("I hate UCPC")
'''

# 공백 : 32, C : 67
