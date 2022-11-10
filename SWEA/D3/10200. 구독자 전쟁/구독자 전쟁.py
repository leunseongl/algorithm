t = int(input())
for tc in range(1, t+1):
    n, a, b = map(int, input().split())
    big = small = 0
    big = min(a,b)
    if a+b>=n:
        small = a+b-n
    else:
        small = 0
    print('#%d' %tc, big, small)