t = int(input())
for tc in range(1, t+1):
    a,b = map(int, input().split())
    if a+b>=24:
        print('#%d' %tc, (a+b)%24)
    else:
        print('#%d' %tc, a+b)