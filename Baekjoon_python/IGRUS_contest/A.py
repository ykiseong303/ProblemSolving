A, B, C = map(int, input().split())
lst = [A, B, C, A*B,A*C, B*C, A*B*C]
# 리스트를 돌며 홀수가 있는지 검사 
ans = []
for l in lst : 
    if l%2 : 
        ans.append(l)
# 홀수가 있다면
if len(ans) >=1 : 
    if len(ans) == 1 :
        print(*ans)
    else : 
        # print(ans)
        print(max(ans))
# 홀수가 없다면 
else : 
    print(max(lst))        
