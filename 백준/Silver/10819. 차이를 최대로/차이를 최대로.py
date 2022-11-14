from itertools import permutations

n = int(input())
a = list(map(int, input().split()))

p = permutations(a)
res = 0

for i in p:
    tmp = 0
    for j in range(len(i)-1):
        tmp += abs(i[j]-i[j+1])
    if tmp > res:
        res = tmp

print(res)