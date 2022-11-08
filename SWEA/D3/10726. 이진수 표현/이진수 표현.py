t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    flag = 0
    for _ in range(n):
        if m%2 == 0:
            flag = 1
        m //= 2
    if flag == 1:
        print('#%d' %tc, 'OFF')
    else:
        print('#%d' % tc, 'ON')