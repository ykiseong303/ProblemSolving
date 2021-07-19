data = input()
index = 0
for d in data :
    if not index%10 and index!=0: 
        print("") 
    print(d,end='')
    index += 1 