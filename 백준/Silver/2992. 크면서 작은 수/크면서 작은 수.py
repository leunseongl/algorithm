import itertools as it

x = int(input())
li = list(map(int, str(x)))
tmp = []
for i in it.permutations(li):
    tmp.append(int(''.join(map(str, i))))
tmp.sort()

if tmp[-1] == x:
    print(0)
else:
    for i in tmp:
        if i>x:
            print(i)
            break
