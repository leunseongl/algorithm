t = int(input())
for tc in range(1, t+1):
    n = int(input())
    happy = []
    for _ in range(n):
        happy.append(int(input()))
    ship = set()
    cnt = 0
    for i in range(1, n):
        if happy[i] in ship:
            continue
        gap = happy[i]-1
        for j in range(gap+1, happy[-1]+1, gap):
            ship.add(j)
        cnt += 1
    print('#%d' %tc, cnt)