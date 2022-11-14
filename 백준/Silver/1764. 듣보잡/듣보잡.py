n, m = map(int, input().split())
li = set()
lo = set()

for _ in range(n):
    li.add(input())

for _ in range(m):
    lo.add(input())

res = sorted(li & lo)

print(len(res))
for i in res:
    print(i)