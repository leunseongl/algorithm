import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    cost = int(input())
    res = [0] * 4
    while cost:
        if cost>=25:
            res[0] = cost//25
            cost = cost%25
        elif cost>=10:
            res[1] = cost//10
            cost = cost%10
        elif cost>=5:
            res[2] = cost//5
            cost = cost%5
        else:
            res[3] = cost//1
            cost = cost%1
    print(*res)