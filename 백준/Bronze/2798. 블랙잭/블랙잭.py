n, m = map(int, input().split())
a = list(map(int, input().split()))
tot = 0
largest = 0
for i in range(n):
    for j in range(i+1, n):
        for k in range(j+1, n):
            tot = a[i]+a[j]+a[k]
            if tot>largest and tot<=m:
                largest = tot
print(largest)

