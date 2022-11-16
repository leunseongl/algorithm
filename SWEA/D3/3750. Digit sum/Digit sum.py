t = int(input())
res = []
for _ in range(1, t+1):
    n = list(input())
    while len(n) != 1:
        tot = 0
        for i in n:
            tot += int(i)
        n = list(str(tot))
    res.append(int(n[0]))

for i in range(t):
    print('#%d' %(i+1), res[i])