li = input()
s = set()
for i in range(len(li)):
    for j in range(i, len(li)):
        tmp = li[i:j+1]
        s.add(tmp)

print(len(s))