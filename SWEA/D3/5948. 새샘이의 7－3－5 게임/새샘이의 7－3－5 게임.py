t = int(input())
for tc in range(1, t+1):
    li = list(map(int, input().split()))
    tot = set()
    for i in range(7):
        for j in range(i+1, 7):
            for k in range(j+1, 7):
                tmp = li[i]+li[j]+li[k]
                tot.add(tmp)
    tot = sorted(tot, reverse=True)
    print('#%d' %tc, tot[4])