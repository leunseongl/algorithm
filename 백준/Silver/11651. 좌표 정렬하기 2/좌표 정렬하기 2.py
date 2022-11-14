n = int(input())
li = []
for _ in range(n):
    x, y = map(int, input().split())
    li.append([x, y])
li.sort(key = lambda x : (x[1], x[0]))

for i in range(n):
    print(li[i][0], li[i][1])