T = int(input())
for i in range(T) : 
    x, y = map(int, input().split())
    print("Case #{}: {} + {} = {}".format(i+1,x,y,x+y))