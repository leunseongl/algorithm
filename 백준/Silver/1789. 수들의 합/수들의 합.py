s = int(input())
n = 1
tot = 0
while True:
    tot += n
    if tot <= s:
        n += 1
    else:
        break
print(n-1)