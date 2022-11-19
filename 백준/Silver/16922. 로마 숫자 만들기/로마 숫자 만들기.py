from itertools import combinations_with_replacement

n = int(input())
num = [1,5,10,50]
tmp = list(combinations_with_replacement(num, n))
s = []
for i in tmp:
    s.append(sum(i))
print(len(set(s)))