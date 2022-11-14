n = int(input())
stairs = [0] * 301

for i in range(n):
    stairs[i] = int(input())

dy = [0] * 301
dy[0] = stairs[0]
dy[1] = max(stairs[0]+stairs[1], stairs[1])
dy[2] = max(stairs[1]+stairs[2], stairs[0]+stairs[2])

for i in range(3, n):
    dy[i] = max(dy[i-3]+stairs[i-1]+stairs[i], dy[i-2]+stairs[i])

print(dy[n-1])

