'''
분류 : 그리디 알고리즘
문제 : 비트 우정지수 (백준 12782번)
작성일자 : 2021.02.28
'''

# 2가지 연산 중 하나를 선택해서 이진 숫자를 같게 만들기
## 목적 : 연산의 횟수를 최소화
## 접근 : 현재 시점에서 가장 중요한 것은 1의 갯수가 같은지 다른지
##       1의 개수만 같다면 바꾸기로 하는 것이 최소화를 시킬 수 있으므로
##       마지막 항의 처리까지 완벽하게 구현하기

def xor(x,y) : 
    count = 0
    for i in range(len(x)) : 
        if x[i] != y[i] : 
            count += 1
    return count  

T = int(input())
x=[]
y=[]
for _ in range(T) : 
    a,b = input().split()
for i in a : 
    x.append(i)
for j in b : 
    y.append(j)
flag = False
result = 0
while flag == False : 
    count = xor(x,y)
    if count%2 : 
        for i in range(len(x)) : 
            if x[i] != y[i] : 
                x[i] = y[i]
                result += 1
                print(result)
                print(x)
                break
    else : 
        print("Else")
        temp = x[0]
        for i in range(len(x)) : 
            if temp != x[i] : 
                x[i] = temp
            if x[i] != y[i] : 
                if x[i] == '0' : 
                    temp = x[i]
                    x[i] = '1'
                    result += 1
                else : 
                    temp = x[i]
                    x[i] = '0'
                    result += 1
                
                print(result)
        flag = True 
print(result)
print(x,y)
                


'''
while flag == False :
    count = xor(x,y)
    # print(count)
    if count%2 : 
        for i in range(len(x)) : 
            if x[i] != y[i] : 
                x[i] = y[i]
                result += 1
                # x.pop(i)
                # x.insert(i,y[i])
                break
    else : 
        for j in range(len(x)) : 
            if x[j] != y[j] :
                print("j",j,x[j],y[j])
                for k in range(j,len(x)) : 
                    print("k", x[k],x[k+1])
                    if k == len(x)-1 : 
                        break
                    elif x[k] != x[k+1] : 
                        print(2222)
                        temp = x[k]
                        x[k] = x[k+1]
                        x[k+1] = temp
                        print(x,y)
                        break
        flag = True
#print(x,y,"\n",result)
'''
