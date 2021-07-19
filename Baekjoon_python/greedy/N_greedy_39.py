'''
분류 : 그리디 알고리즘
문제 : 책 나눠주기 (백준 9576번)
작성일자 : 2021.03.15
'''
# 책 N권, M명의 사람이 있고, 각 사람은 1<=a<=b<=N 에 해당하는 a,b를 입력
# 범위에 해당하는 책이 있으면 주고, 아니면 안줌
## 목적 : 최대로 책을 받을 수 있는 사람의 수를 출력 
## 접근 : a가 작고 b가 작은 것을 기준으로 내림차순 정렬해서 b가 N보다 작거나 같으면 되는 걸로
##       이분매칭 확인 후 재풀이 


# 아래와 같은 방식으로 풀었을 때 틀리는데, 반례를 모르겠음 
import sys

T = int(input())
for _ in range(T) : 
    N, M = map(int, input().split())
    books = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(M)]
    # 시작번호, 끝 번호 순으로 정렬 
    books.sort(key=lambda x:(x[1],x[0]), reverse=True)
    # print(books)
    count = 0

    for book in books : 
        if N == 0 : 
            break
        max_val = book[1]
        # print("book[1]",max_val,"book[0]",book[0])
        while max_val >= book[0] : 
            # if book == 0 : 
            #     break
            if max_val <= N :
                count += 1
                N -= 1 
                break
            else : 
                max_val -= 1
    print(count)


