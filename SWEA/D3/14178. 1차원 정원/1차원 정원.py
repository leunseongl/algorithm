t = int(input())
for tc in range(1, t+1):
    n, d = map(int, input().split())
    water = d*2+1
    res = n//water
    if n%water != 0:
        res += 1
    print('#%d' %tc, res)