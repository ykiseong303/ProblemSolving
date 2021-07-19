N = int(input())
flag = True
if N%2 : # 홀수인경우
    flag = False 
ans = []
for i in range(N) : 
    if not i%2 : 
        ans.append(1)
        # print(1,end=" ")
    else : 
        ans.append(2)
        # print(2,end=" ")

if flag == False : 
    ans[-1] = 3 
print(*ans)
