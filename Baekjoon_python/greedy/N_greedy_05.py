'''
분류 : 그리디 알고리즘
문제 : 모험가 길드 (실패)
작성일자 : 2021.02.27
'''

# N명의 모험가는 각각 X의 공포도를 가진다 
# 그룹을 지어 모험을 떠나는데 각 그룹은 공포도가 X인 사람이 X명 있어야 그룹가능
# N명의 인원에 대해 각각 공포도 X가 입력
## 목적 : N명의 인원으로 최대 그룹의 수를 출력
## 접근 : 공포도 X가 작은 사람들 부터 그룹화 
## 오름차순으로 정렬되어 있기 때문에, 항상 최소한의 인원으로 그룹을 만들 수 있음
'''
n = int(input())
person = list(map(int, input().split()))
person.sort()
print(person)
count = 0
group = []
for i in person : 
    group.append(i)
    if i == len(group) : 
        count += 1
        group.clear()
print(count)
'''
person = list(input().split())
count = 0
group = []
for i in person : 
    print(i)
    group.append(i)
    if i == '1' : 
        count += 1
        group.clear() 
    elif len(group) == int(i) : 
        print("elif", i)
        flag = 0
        for j in group : 
            if i == j :
                flag += 1
        print("flag",flag)
        if flag == len(group) :        
            count += 1
            print(group) 
            group.clear()
            print("end")
        elif len(group) - flag == 1 : 
            print("pop",group[0],group)
            group.pop(0)
            #group.clear()
            #group.append(i)
            print("pop after", group)
        else : 
            group.clear()
    else : 
        print(i, "out", group)
    #print("group", len(group))
    
print(count)

'''
n = int(input())
data = list(map(int, input().split()))
data.sort()

count = 0 
result = 0

for i in data : 
    count += 1 
    if count >= i : 
        result += 1 
        count = 0
print(result)

'''