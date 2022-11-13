t = int(input())
for tc in range(1, t+1):
    n, q = map(int, input().split())
    box = [0] * n
    for i in range(1, q+1):
        a, b = map(int, input().split())
        for j in range(a-1, b):
            box[j] = i
    print('#%d' %tc, *box)