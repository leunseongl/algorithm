n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
tot = 0
for _ in range(n):
    tot += min(a)*max(b)
    a.remove(min(a))
    b.remove(max(b))
print(tot)