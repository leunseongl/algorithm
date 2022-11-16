n = int(input())
li = list(map(int, input().split()))
for i in range(n-1, 0, -1):
    if li[i] < li[i-1]:
        for j in range(n-1, 0, -1):
            if li[j] < li[i-1]:
                li[j], li[i-1] = li[i-1], li[j]
                li = li[:i] + sorted(li[i:], reverse=True)
                print(*li)
                exit()
print(-1)
