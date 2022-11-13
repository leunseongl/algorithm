t = int(input())
for tc in range(1, t+1):
    n, m, k = map(int, input().split())
    cus = list(map(int, input().split()))
    cus.sort()
    flag = 'Possible'
    for i in range(n):
        tmp = (cus[i]//m)*k - (i+1)
        if tmp<0:
            flag = 'Impossible'
            break
    print('#%d' %tc, flag)