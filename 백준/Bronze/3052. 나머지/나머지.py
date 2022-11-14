n = []

for i in range(10):
    a = int(input())
    n.append(a%42)

a = set(n)
print(len(a))