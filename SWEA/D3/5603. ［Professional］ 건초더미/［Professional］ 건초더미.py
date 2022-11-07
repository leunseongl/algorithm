t = int(input())
for tc in range(1, t+1):
    n = int(input())
    grass = [int(input()) for _ in range(n)]
    avg = sum(grass)//n
    res = 0
    for i in grass:
        res += abs(i-avg)
    print('#%d' %tc, res//2)