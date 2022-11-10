t = int(input())
for tc in range(1, t+1):
    a, b, c = map(int, input().split())
    if a >= b:
        print('#%d' %tc, c//b)
    else:
        print('#%d' %tc, c//a)