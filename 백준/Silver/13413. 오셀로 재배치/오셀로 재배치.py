t = int(input())
for _ in range(t):
    n = int(input())
    now = list(input())
    goal = list(input())
    tmp = 0
    dif = []
    while True:
        if tmp == n:
            break
        if now[tmp] != goal[tmp]:
            dif.append(now[tmp])
        tmp += 1
    w = dif.count('W')
    b = dif.count('B')
    if w>=b:
        print(w)
    else:
        print(b)