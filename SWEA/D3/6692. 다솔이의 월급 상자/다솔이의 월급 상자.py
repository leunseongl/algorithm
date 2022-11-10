t = int(input())
for tc in range(1, t+1):
    n = int(input())
    tot = 0
    for _ in range(n):
        p, x = map(float, input().split())
        tot += (p*x)
    print('#%d' %tc, format(tot, ".6f"))