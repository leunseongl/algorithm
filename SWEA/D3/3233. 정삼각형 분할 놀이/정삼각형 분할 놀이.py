t = int(input())
for tc in range(1, t+1):
    a, b = map(int, input().split())
    if a>b:
        if b == 1:
            print('#%d' %tc, a//b*a)
        else:
            print('#%d' %tc, (a//b*a)//b)
    else:
        print('#%d' %tc, a//b)