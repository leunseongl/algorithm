cal = input().split('-')
tot = 0
for i in cal[0].split('+'):
    tot += int(i)

for i in cal[1:]:
    for j in i.split('+'):
        tot -= int(j)

print(tot)