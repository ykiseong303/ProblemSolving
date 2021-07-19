'''
분류 : 다이나믹 프로그래밍
문제 : 가장 큰 증가 부분 수열 (백준 11055)
작성일자 : 2021.07.05
'''

# 목적 : 합이 가장 큰 증가 부분 수열의 합을 출력
# 접근 : 원리는 LIS와 동일 
#       점화식 ai = i번째를 마지막으로 갖는 부분수열의 합
#       i번째 값이 이전 값(i-1, i-2 ...)보다 크다면 dp 테이블을 갱신
#       단, 합을 출력해야 하므로 dp테이블의 값이 합으로 갱신되도록 지정
#       또한, dp테이블을 초기화할 때 입력받은 리스트 그 자체로 사용
#       리스트의 값 하나하나가 원래의 값을 갖고 있어야 하기 때문에 1이나 0으로 초기화하면 안됌


N = int(input())
lst = list(map(int, input().split()))
d = [x for x in lst] # dp테이블을 입력받은 리스트로 복사
for i in range(1, N) : 
    for j in range(i) : 
        if lst[i] > lst[j] : 
            d[i] = max(d[i], lst[i]+d[j])
# print(d)
print(max(d))