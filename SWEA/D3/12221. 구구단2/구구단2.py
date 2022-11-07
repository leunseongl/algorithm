t = int(input())
for tc in range(1, t+1):
    a, b = map(int, input().split())
    if 0<a<=9 and 0<b<=9:
        print('#%d' %tc, a*b)
    else:
        print('#%d' %tc, -1)