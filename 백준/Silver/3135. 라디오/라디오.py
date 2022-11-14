a, b = map(int, input().split())
hz = []
n = int(input())
sum1 = abs(b-a)

for _ in range(n):
    hz.append(int(input()))

for i in range(n):
    hz[i] = abs(b-hz[i])

sum2 = min(hz)+1
print(min(sum1, sum2))
