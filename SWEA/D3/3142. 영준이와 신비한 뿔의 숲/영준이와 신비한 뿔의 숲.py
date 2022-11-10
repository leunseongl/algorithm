t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    uni = 2*m-n
    twin = m-uni
    print('#%d' %tc, uni, twin)