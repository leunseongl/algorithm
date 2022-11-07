import math

t = int(input())
for tc in range(1, t+1):
    a,b = map(int, input().split())
    cnt = 0
    for i in range(a, b+1):
        rt = math.sqrt(i)
        if rt == int(rt):
            i = str(i)
            rt = str(int(rt))
            if i == i[::-1] and rt == rt[::-1]:
                cnt += 1
    print('#%d' %tc, cnt)