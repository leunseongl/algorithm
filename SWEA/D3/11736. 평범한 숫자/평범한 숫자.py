t = int(input())
for tc in range(1, t+1):
    n = int(input())
    li = list(map(int, input().split()))
    cnt = 0
    for i in range(1, n-1):
        if 2<=li[i]<=n-1:
            tmp = li[i-1:i+2]
            big = max(tmp)
            small = min(tmp)
            if li[i] != big and li[i] != small:
                cnt += 1
    print('#%d' %tc, cnt)