n = input()
n = sorted(n, reverse=True)
tot = 0

if '0' not in n:
    print(-1)
else:
    for i in n:
        tot += int(i)
    if tot%3 == 0:
        for j in n:
            print(j, end='')
    else:
        print(-1)