from collections import deque

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    printer = [(pos, val) for pos, val in enumerate(list(map(int, input().split())))]
    printer = deque(printer)
    cnt = 0
    while True:
        cur = printer.popleft()
        if any(cur[1] < x[1] for x in printer):
            printer.append(cur)
        else:
            cnt += 1
            if cur[0] == m:
                print(cnt)
                break