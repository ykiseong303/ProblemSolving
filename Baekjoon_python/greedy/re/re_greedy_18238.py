'''
분류 : 그리디 알고리즘 (재풀이)
문제 : ZOAC (백준 18238번)
작성일자 : 2021.03.22
'''

# 목적 : 회전판에서 문자열을 출력하는데 걸리는 최소시간을 출력
# 접근 : 현재를 기준으로 왼쪽 오른쪽 방향 중 더 짧게 걸리는 방향을 선택한다 
#       1에서 26으로 역방향으로 가려면 1- 26에 단위 값 27을 더하면 된다
#       26진법이라 생각하고, 27이 될때마다 단위가 늘어난다고 생각하면 됨

lst = input()

count = 0
answer = 0
start = 'A'
for l in lst : 
    left = ord(l) - ord(start)
    right = ord(start) - ord(l) 

    if left < 0 : 
        left += 26
    if right < 0 : 
        right += 26

    answer += min(left,right)
    start = l
print(answer)