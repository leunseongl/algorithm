import sys
input = sys.stdin.readline

x, y = map(int, input().split())
ga = [0, x]
se = [0, y]
n = int(input())
for _ in range(n):
    a, b = map(int, input().split())
    if a == 0:
        se.append(b)
    else:
        ga.append(b)

ga.sort()
se.sort()
garo = []
sero = []
for i in range(1, len(ga)):
    garo.append(ga[i]-ga[i-1])
for i in range(1, len(se)):
    sero.append(se[i]-se[i-1])

res = 0
for i in garo:
    for j in sero:
        if i*j>res:
            res = i*j
print(res)