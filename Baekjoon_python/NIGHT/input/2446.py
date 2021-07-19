N = int(input())
for i in range(1,N+1):
    print(" "*(i-1)+"*"*((N*2-1)-2*(i-1)))
for i in range(1,N) : 
    print(" "*(N-i-1)+"*"*(3+2*(i-1)))