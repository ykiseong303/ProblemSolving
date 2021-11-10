import sys 
input = sys.stdin.readline

def comb(cnt, start) :
    if cnt == C : 
        print(sel)
        return
    for i in range(start, R) :
        sel[cnt] = lst[i]
        comb(cnt+1, i+1)

R, C = map(int, input().split())
lst = list(map(int, input().split()))
sel = [0] * C

comb(0,0)