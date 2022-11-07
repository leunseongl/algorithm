t = int(input())
for tc in range(1, t+1):
    s = list(input())
    h = int(input())
    idx = list(map(int, input().split()))
    idx.sort(reverse=True)
    for i in idx:
        s.insert(i, '-')

    print('#%d' %tc, end=' ')
    for i in s:
        print(i, end='')
    print()