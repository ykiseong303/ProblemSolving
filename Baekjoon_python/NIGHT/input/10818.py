import sys 
N = int(input())
lst = list(map(int, sys.stdin.readline().rstrip().split()))
print(min(lst), max(lst))