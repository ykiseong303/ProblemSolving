'''
분류 : 다이나믹 프로그래밍
문제 : 피보나치 수열 (이코테 예제)
작성일자 : 2021.05.20
'''  
print("commit test")
# 목적 : 피보나치 수열을 출력한다
# 접근 : 시간초과 방지를 위해 DP를 이용한다(메모이제이션)


# 피보나치 수열을 재귀적으로 푸는 경우
# 불필요한 연산이 중복되므로 시간효율성이 매우떨어짐 (시간복잡도가 지수형태)

'''import sys 
sys.setrecursionlimit(100000)

def fibo(x) : 
    # print(x)
    if x == 1 or x == 2 : 
        return 1 
    return fibo(x-1) + fibo(x-2) # -1번째 항과 -2번째 항을 재귀호출

for i in range(1,10) :
    print(fibo(i)) # i번째 피보나치 수를 출력
'''

# 그러므로 이전에 계산한 값을 기록함으로써 시간 효율성을 높이기

## 먼저, DP를 사용할 수 있는 경우를 생각하기
## 1. 최적 부분 구조인가? > 3번째 수를 구하기 위해서는 1,2번째의 값으로 구할 수 있으므로 작은 문제로 큰 문제를 해결할 수 있음
## 2. 중복 부분 문제가 발생? > f(2)의 값을 지속적으로 계산, 작은 부분문제가 중복적으로 발생하고 있음


# 1. 탑다운 방식 (재귀함수를 사용)
## 비효율적인 재귀방식을 작성하고, 최적부분구조(작 > 큰), 부분중복문제가 있다면 DP로 코드를 변경
## 탑다운 방식은 제일 아래까지는 한 번 실행해야함, 이후 계산된 값을 기록하고 이를 사용

'''d = [0] * 100 # 99까지 계산된 결과를 메모이제이션하기 위한 리스트 초기화

def fibo(x) : 
    if x == 1 or x == 2 : # 재귀 종료조건
        return 1
    if d[x] != 0 : # 이전에 계산한 적이 있다면
        return d[x] # 기록된 값을 그대로 리턴
    d[x] = fibo(x-1) + fibo(x-2) # 계산한 적이 없다면 작은 문제들로 재귀호출하여 수행
    return d[x] # x번째의 피보나치 수를 리턴
for i in range(1,100) : 
    print(fibo(i))'''

# 2. 바텀업 방식 (반복문 사용)
## 작은 문제들을 먼저 해결하고, 이를 조합해서 큰 문제들을 차례대로 해결
## 탑다운 방식은 아래로 내려가기 때문에, 이미 계산된 값일지라도 재귀 호출을 하긴 해야함
## 바텀업 방식은 아래에서 위로 한단계씩 중복 없이 차례대로 올라감

d = [0] * 100 # 계산된 결과를 기록하기 위한 DP테이블 초기화
d[1], d[2] = 1, 1 # 초기값 설정
n = 99
for i in range(3,n+1) : 
    d[i] = d[i-2] + d[i-1] # 이전에 계산된 값을 그대로 사용, 한단계씩 위로 이동
    print(d[i])