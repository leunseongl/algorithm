n = int(input())
li = list(map(int, input().split()))
dy = [0] * n
dy[0] = li[0]

for i in range(1, n):
    dy[i] = max(dy[i-1]+li[i], li[i])

print(max(dy))