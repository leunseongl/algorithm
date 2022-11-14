import sys
input = sys.stdin.readline

while True:
    n = int(input())
    if n == 0:
        break

    cnt = 0
    a = [True] * (2*n+1)
    for i in range(2, int((n * 2) ** 0.5) + 1):
        if a[i]:
            for j in range(i, n*2+1, i):
                a[j] = False

    for x in range(n+1, 2*n+1):
        if a[x] == True:
            cnt += 1

    print(cnt)
