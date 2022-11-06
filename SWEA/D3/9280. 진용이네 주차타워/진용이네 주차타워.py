t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    charge = []
    weight = []
    park = [0] * (n+1)
    wait = []
    res = 0
    for _ in range(n):
        charge.append(int(input()))
    for _ in range(m):
        weight.append(int(input()))
    for i in range(m*2):
        info = int(input())
        if info>0:
            for j in range(1, n+1):
                if park[j] == 0:
                    park[j] = info
                    res += charge[j-1] * weight[info-1]
                    break
            else:
                wait.append(info)
        else:
            for j in range(1, n+1):
                if park[j] == abs(info):
                    if len(wait) != 0:
                        park[j] = wait[0]
                        res += charge[j-1] * weight[wait[0]-1]
                        wait.pop(0)
                    else:
                        park[j] = 0
    print('#%d' %tc, res)