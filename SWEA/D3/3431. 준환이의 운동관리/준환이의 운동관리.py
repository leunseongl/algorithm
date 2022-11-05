t = int(input())
for tc in range(1, t+1):
    l, u, x = map(int, input().split())
    if x>u:
        print('#%d' %tc, -1)
    elif l<=x<=u:
        print('#%d' %tc, 0)
    else:
        print('#%d' %tc, l-x)