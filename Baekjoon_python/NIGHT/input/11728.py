import sys
N, M = map(int, input().split())
A = list(map(int, sys.stdin.readline().rstrip().split()))
B = list(map(int, sys.stdin.readline().rstrip().split()))
A.extend(B)
print(*sorted(A))