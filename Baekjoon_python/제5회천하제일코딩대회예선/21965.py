import sys 
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
target = A[0]
flag = False
for i in range(1,len(A)) : 
    if target == A[i] :
        print("NO")
        sys.exit()
    if target < A[i] : 
        if flag == False : 
            target = A[i]
        else : 
            print("NO")
            sys.exit()
    if target > A[i] and flag == False : 
        if i == 1 : 
            print("NO")
            sys.exit()
        else : 
            flag = True 
print("YES")