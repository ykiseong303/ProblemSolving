'''
분류 : 그리디 알고리즘
문제 : 컵홀더 (백준 2810)
작성일자 : 2021.03.13
'''
# 좌석 양 끝에 컵홀더가 1개씩 있고, 커플석에는 가운데는 없다
## 목적 : 컵을 꽂을 수 있는 최대 사람의 수 출력
## 접근 : 현재 자리에서 최대한 사용할 수 있는 컵홀더 모두 사용
##       첫 커플석 자리만 2개 사용가능 하다는 조건 찾아내기
## LL을 L로 바꾸는 방법은 replace를 사용 가능하다 
# seats = input().replace('LL','L')
### 아니면 L의 개수를 모두 더한뒤 나누기 2를 해주면 L을 한번만 세는 걸로도 가능하다
N = int(input())
cup = input()
seats = []
for s in cup : 
    seats.append(s)
s_cnt = seats.count('S')
l_cnt = seats.count('L')//2
if l_cnt == 1 : 
    print(s_cnt+2)
elif l_cnt > 1 : 
    print(s_cnt+l_cnt+1)
else : 
    print(s_cnt)