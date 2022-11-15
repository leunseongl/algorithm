sosu = []
for i in range(2, 1000):
    for j in range(2, i):
        if i % j == 0:
            break
    else:
        sosu.append(i)

t = int(input())
for tc in range(1, t+1):
    n = int(input())
    m = len(sosu)
    cnt = 0
    for i in range(m):
        if sosu[i] > n:
            break
        for j in range(i, m):
            if sosu[j] > n:
                break
            for k in range(j, m):
                if sosu[k] > n:
                    break
                    
                if sosu[i] + sosu[j] + sosu[k] == n:
                    cnt += 1
    print('#%d' %tc, cnt)