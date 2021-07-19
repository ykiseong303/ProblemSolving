'''
분류 : 그리디 알고리즘 (재풀이)
문제 : 신입사원 (백준 1946번)
작성일자 : 2021.03.26
'''

# 목적 : 최대로 선발할 수 있는 신입사원 수를 출력
# 접근 : 어느하나의 성적 중 가장 높은 사람을 기준으로 잡고, 그 사람의 다른 성적을
#       다른 후보자의 해당 과목의 성적과 비교한다. 성적이 높다면 기준을 변경하고 추가한다
##      이 문제의 핵심은 하나의 과목에서 가장 높은 사람이 아니면 다른 사람은 그 지원자보다
##      성적이 떨어지므로, 그 과목의 점수는 볼 필요가 없다 (문제에서 적어도 하나가 다른 지원자보다 떨어지지 않는 이라고 기재)
#       낮을 수록 순위가 높다는 것을 인지 

import sys
T = int(input())
for _ in range(T) : 
    N = int(input())
    people = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
    # 성적 하나를 기준으로 내림차순으로 정렬한다 
    people.sort(key=lambda x: x[0])
    # x[0]번째 성적을 기준으로 가장 높은 사람을 한명 뽑아놓고 시작한다 
    count = 1 
    # 가장 높은 사람의 다른 성적을 기준으로 잡는다
    target = people[0][1]
    for i in range(1,N) : 
        # 현재 기준보다 성적이 높다면 사원으로 채택하고 기준을 바꾼다 
        if people[i][1] < target : 
            count += 1 
            target = people[i][1]
    print(count)