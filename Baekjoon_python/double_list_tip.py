# 파이썬 이중 리스트 팁

# 1. 이중리스트를 정렬하기 
lst = [[1,10],[2,9],[3,8]]
# x[0]은 각 원소의 0번째(왼쪽 값)를 기준으로 정렬 [1,10]에서 왼쪽 값인 1을 기준으로
lst.sort(key= lambda x : x[0], reverse=True)

# 2. 리스트를 리스트에 append하기 
# []으로 묶어서 append하면 됌
lst.append([4,7])

# 3. 이중 리스트에서 특정 값이 있는지 확인하기 
# for와 in을 사용
# 리스트에서 리스트를 꺼내오기
for l in lst :
    # 문자열이나 정수형 상관 없음
    if 1 in l : 
        print("yes")

# 4. 이중 리스트에서 max 값 찾기
# 문자열, 정수형 조합에서는 정수형의 값을 기준으로 찾음 
lst = [["1",1],["-1",-1]]
print(max(lst))
lst = [[1,"1"],[-1,"-1"]]
print(max(lst))

# 5. 이중 리스트에서 max 값 찾기 
# map함수를 이용, 이중리스트의 각 원소리스트 중 최대 값을 출력
max(map(max,shape))

# 6. 입력되는 리스트가 공백없이 오는 경우 
# strip()으로 끝내고 list로 감싸면 하나하나씩 빠져 나온다
lst = list(sys.stdin.readline().strip())
print(lst)
# list로 감싸면 다 되는 것 같다. 
lst = [list(input()) for _ in range(N)]