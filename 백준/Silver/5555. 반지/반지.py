find = input()
n = int(input())
cnt = 0
tmp = []
for _ in range(n):
    li = input()
    li = li*2
    if find in li:
        cnt += 1
print(cnt)