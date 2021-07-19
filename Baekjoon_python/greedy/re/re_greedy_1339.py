'''
분류 : 그리디 알고리즘 (재풀이)
문제 : 단어수학 (백준 1339번)
작성일자 : 2021.03.26
'''

# 목적 : 입력된 단어들로 만들 수 있는 합의 최댓값
# 접근 : 단위가 가장 높은 단어에 높은 값을 부여한다 
#       딕셔너리를 사용하여 해당 알파벳의 단위를 기록해 둔다
#       딕셔너리의 key와 value를 보기 위한 함수 (keys(), values()) 기억
#       추가로 딕셔너리를 정렬하는 방법 

N = int(input())
lst = [list(input()) for _ in range(N)]
# 각 알파벳의 자리수를 표현하기 위한 딕셔너리를 생성
alphabet = {}
for one in lst : 
    for i in range(len(one)) : 
        if one[i] not in alphabet : 
            alphabet[one[i]] = pow(10,len(one)-i-1)
        else : 
            alphabet[one[i]] += pow(10,len(one)-i-1)

# 딕셔너리 중 숫자 값만을 리스트에 따로 저장한다
num = []
for value in alphabet.values() : 
    num.append(value)
num.sort(reverse=True)
# a = sorted(alphabet.items(), key=lambda x: x[1], reverse= True)
index = 9
ans = 0
# print(a[0])
for i in range(len(num)) : 
    ans += index * num[i]
    index -= 1
print(ans)

