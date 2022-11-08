t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    sub = list(map(int, input().split()))
    print('#%d' %tc, end=' ')
    for i in range(1, n+1):
        if i not in sub:
            print(i, end=' ')
    print()