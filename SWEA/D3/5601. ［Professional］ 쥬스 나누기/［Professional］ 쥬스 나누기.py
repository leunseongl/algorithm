t = int(input())
for tc in range(1, t+1):
    n = int(input())
    res = []
    for _ in range(n):
        res.append('1/%d' %n)
    print('#%d' %tc, end=' ')
    print(*res)