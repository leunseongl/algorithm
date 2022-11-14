month = {1:31, 2:28, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12: 31}
week_day = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
m, d = map(int, input().split())
day = 0
for i in range(1, m):
    day += month[i]
day += d
week = day%7
print(week_day[week])
