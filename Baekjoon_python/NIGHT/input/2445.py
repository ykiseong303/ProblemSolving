N = int(input())
for i in range(1,2*N) : 
    if i < N : 
        print('*'*i + ' '*((N*2)-i*2)+'*'*i)
    if i == N :
        print('*'*(N*2))
    if i > N : 
        print('*'*((N*2)-i)+' '*((N*2)-((N*2)-i)*2)+'*'*((N*2)-i))  
