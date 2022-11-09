weekday = {'SUN':7, 'MON':6, "TUE":5, 'WED':4, 'THU':3, 'FRI':2, 'SAT':1}

t = int(input())
for tc in range(1, t+1):
    info = input()
    print('#%d' %tc, weekday.get(info))