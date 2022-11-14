box = [[0]* 100 for _ in range(100)]
cnt = 0

for _ in range(4):
    a, b, c, d = map(int, input().split())
    for i in range(a, c):
        for j in range(b, d):
            if box[i][j] == 0:
                box[i][j] = 1
                cnt += 1
print(cnt)
