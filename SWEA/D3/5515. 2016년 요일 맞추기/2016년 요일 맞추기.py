month = {1:31, 2:29, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12:31}
week = [3,4,5,6,0,1,2]
t = int(input())
for tc in range(1, t+1):
    m, d = map(int, input().split())
    day = 0
    for i in range(1, m):
        day += month[i]
    day += d
    res = day%7
    print('#%d' %tc, week[res])