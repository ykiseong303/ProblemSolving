import sys 
lst = sys.stdin.readline().rstrip()

max_lst = []
min_lst =[]
count = 0
# 리스트에 K가 있는지 검사
if 'K' in lst : # K가 존재하는 경우
    # 큰 경우
    for i in range(len(lst)) : 
        if i == len(lst)-1  and lst[i] == 'M' : 
            count += 1
            for a in range(count) : 
                max_lst.append('1')
        if lst[i] == 'K' : 
            max_lst.append(str(5*pow(10,count)))
            count = 0
        else : 
            count += 1
    count = 0
    # 작은 경우
    for  j in range(len(lst)) : 
        if j == len(lst)-1 and lst[j] == 'M' : 
            count += 1
            min_lst.append(str(pow(10,count-1)))
        if lst[j] == 'K' : 
            if count == 0 : 
                min_lst.append('5')
            else : 
                min_lst.append(str(1*pow(10,count-1)))
                min_lst.append('5')
                count = 0
        else : 
            count += 1
    max_lst = "".join(max_lst)
    min_lst = "".join(min_lst)
    print(max_lst)
    print(min_lst)
        


else : # K가 없는 경우
    # 큰 경우
    max_lst = ['1'] * len(lst)
    max_lst = "".join(max_lst)
    min_lst = pow(10,len(lst)-1)
    print(max_lst)
    print(min_lst)


