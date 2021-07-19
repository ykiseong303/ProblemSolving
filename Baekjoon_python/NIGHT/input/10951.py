# 테스트 케이스가 입력되지 않는 경우
while True : 
    try : 
        x, y = map(int, input().split())
        print(x+y)
    except : 
        break