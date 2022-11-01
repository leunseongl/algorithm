import sys
input = sys.stdin.readline

for _ in range(4):
    x1, y1, p1, q1, x2, y2, p2, q2 = map(int, input().split())
    if x2>p1 or q2<y1 or p2<x1 or y2>q1:
        print("d")
    elif y1 == q2:
        if x1 == p2 or p1 == x2:
            print("c")
        else:
            print("b")
    elif p1 == x2:
        if q1 == y2 or y1 == q2:
            print("c")
        else:
            print("b")
    elif x1 == p2:
        if q1 == y2 or y1 == q2:
            print("c")
        else:
            print("b")
    elif q1 == y2:
        if x1 == p2 or p1 == x2:
            print("c")
        else:
            print("b")
    else:
        print("a")