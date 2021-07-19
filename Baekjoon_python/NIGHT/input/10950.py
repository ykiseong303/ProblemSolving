import sys 
T = int(input())
for _ in range(T) : 
    x, y = map(int, sys.stdin.readline().rstrip().split())
    print(x+y)