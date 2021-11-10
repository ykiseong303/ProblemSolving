import sys 

input = sys.stdin.readline

def perm(cnt,v) :
    if cnt == C :
        print(sel)
        return
    for i in range(R) :
        # print("i : ",i)
        if v[i] == 0 :
            # print("here")
            sel[cnt] = lst[i]
            v[i] = 1
            perm(cnt+1,v)
            v[i] = 0

R, C = map(int ,input().split())
lst = list(map(int, input().split()))
sel = [0] * C
# isSelected = [0] * R
v = [0] * R
# print(isSelected[0])
# print(lst[0])
perm(0,v)
