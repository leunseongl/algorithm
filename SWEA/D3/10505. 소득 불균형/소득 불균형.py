t = int(input())
for tc in range(1, t+1):
    n = int(input())
    num = list(map(int, input().split()))
    avg = sum(num)//n
    cnt = 0
    for i in num:
        if i <= avg:
            cnt += 1
    print('#%d' %tc, cnt)