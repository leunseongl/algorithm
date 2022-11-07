t = int(input())
for tc in range(1, t+1):
    a, b, c = map(int, input().split())
    d, h, m = a-11, b-11, c-11
    res = (d*1440)+(h*60)+m
    if res>=0:
        print('#%d' %tc, res)
    else:
        print('#%d' %tc, -1)