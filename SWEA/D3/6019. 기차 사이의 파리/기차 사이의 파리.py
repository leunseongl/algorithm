t = int(input())
for tc in range(1, t+1):
    d, a, b, f = map(int, input().split())
    time = d/(a+b)
    fly = time*f
    print('#%d' %tc, fly)