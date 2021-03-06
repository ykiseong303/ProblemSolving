'''
분류 : 그리디 알고리즘
문제 : 곱하기 혹은 더하기 (이코테)
작성일자 : 2021.02.26
'''

# 0~9로 이루어진 문자열이 입력될 때 
# 왼쪽에서 오른쪽문자로 +, *중 하나를 선택하여 연산 > 가장 큰 결과를 출력
## 목적 : 연산하고 난 뒤, 가장 큰 값 출력하기
## 접근 : 무조건 곱하기를 선택하되, 1이하의 수가 나오면 더하기를 선택
## 처음이 0이 나오면 다음수는 뭘 곱해도 0 이므로 일단 더하도록 선택

num = input()
result = 0
for i in range(len(num)) : 
    if int(num[i]) <= 1 or result <=1: 
        result += int(num[i])
    elif int (num[i]) > 1 : 
        result *= int(num[i])
print(result)

