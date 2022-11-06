t = int(input())
for tc in range(1, t+1):
    n = int(input())
    num = ''
    while True:
        num += ''.join(map(str, input().split()))
        if len(num) == n:
            break
    tmp = 0
    res = 0
    while True:
        if str(tmp) not in num:
            res = tmp
            break
        tmp += 1
    print('#%d' %tc, res)