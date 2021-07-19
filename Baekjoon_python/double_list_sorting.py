# 리스트를 N번 입력받을 때 정렬시켜서 입력받기 

N = int(input())
lst = []
for _ in range(N) : 
    lst.append(sorted(list(map(int, input().split()))))
print(lst)

## 입력
# 2
# 1 7 5
# 9 8 3
## 결과 출력
# [[1, 5, 7], [3, 8, 9]]