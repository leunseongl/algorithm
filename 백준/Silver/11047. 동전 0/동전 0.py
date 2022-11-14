n, k = map(int, input().split())
money = []
for _ in range(n):
    a = int(input())
    money.append(a)
money.sort(reverse=True)
cnt = 0
for i in money:
    if k >= i:
        cnt+=k//i
        k %= i
        if k <= 0:
            break
print(cnt)
