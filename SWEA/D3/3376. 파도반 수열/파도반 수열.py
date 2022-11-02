t = int(input())
for tc in range(1, t+1):
    n = int(input())
    dy = [0] * 101
    dy[1] = 1
    dy[2] = 1
    for i in range(3, n+1):
        dy[i] = dy[i-3] + dy[i-2]
    print('#%d' %tc, dy[n])