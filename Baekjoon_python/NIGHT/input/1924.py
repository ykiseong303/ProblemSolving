month_list = [31,28,31,30,31,30,31,31,30,31,30,31]
week_list = ['SUN','MON','TUE','WED','THU','FRI','SAT']

x, y = map(int, input().split())
day = 0
for i in range(x-1) : 
    day += month_list[i]
day += y
print(week_list[day%7])

'''def day(y) : 
    if y%7 == 1 : 
        return 'MON'
    elif y%7 == 2 : 
        return 'TUE'
    elif y%7 == 3 : 
        return 'WED'
    elif y%7 == 4 : 
        return 'THU'
    elif y%7 == 5 : 
        return 'FRI'
    elif y%7 == 6 : 
        return 'SAT'
    elif y%7 == 0 : 
        return 'SUN'
month = {
    1 : 31,
    2 : 28,
    3 : 31,
    4 : 30,
    5 : 31, 
    6 : 30,
    7 : 31,
    8 : 31,
    9 : 30,
    10 : 31, 
    11 : 30,
    12 : 31
}
x, y = map(int, input().split())
sum = 0
if x == 1 : 
    print(day(y))
else : 
    for i in range(1,x) : 
        sum += month[i]
    sum += y
    print(day(sum))'''