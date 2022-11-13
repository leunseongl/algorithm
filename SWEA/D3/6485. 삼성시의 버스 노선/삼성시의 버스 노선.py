t = int(input())
for tc in range(1, t+1):
    n = int(input())
    a_li = []
    b_li = []
    for _ in range(n):
        a, b = map(int, input().split())
        a_li.append(a)
        b_li.append(b)
    p = int(input())
    res = []
    for _ in range(p):
        cnt = 0
        c = int(input())
        for i in range(n):
            if a_li[i] <= c <= b_li[i]:
                cnt += 1
        res.append(cnt)
    print('#%d' %tc, *res)