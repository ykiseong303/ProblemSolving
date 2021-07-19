# 두개의 리스트를 반복을 돌리는데, 한쪽의 리스트는 해당 인덱스를 계속 유지해야 하는 경우
# for와 while을 사용해서 구현한다

a = [1,2,3]
b = [1,2,3,4,5]
result = []

index = 0
for i in range(len(a)) : 
    # b의 반복은 1회만 시행
    # 그러므로 기존의 인덱스가 보존되어야 하는 상태
    ## while의 탈출조건으로 b의 인덱스 조회보다 index가 리스트의 크기보다
    ## 작은지를 먼저 확인해야함
    while index < len(b) and a[i] >= b[index] :
        result.append(b[index])
        index += 1 
print(result)
