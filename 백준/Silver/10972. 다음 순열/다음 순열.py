n = int(input())
li = list(map(int, input().split()))
x, y = 0, 0
for i in range(n-1, 0, -1):
    if li[i-1] < li[i]:
        for j in range(n-1, 0, -1):
            if li[j] > li[i-1]:
                li[j], li[i-1] = li[i-1], li[j]
                li = li[:i] + sorted(li[i:])
                print(*li)
                exit()
print(-1)