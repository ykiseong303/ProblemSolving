N = int(input())
for i in range(1,N+1) : 
    if i == N : 
        print("*"*(N*2-1))
        break
    print(" "*(N-i),end='')
    print("*"+" "*(1+2*(i-2))+"*"*(1 if i!=1 else 0))