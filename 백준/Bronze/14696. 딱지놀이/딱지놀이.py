import sys
input = sys.stdin.readline

round = int(input())
for _ in range(round):
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    n = a[0]
    m = b[0]
    a.pop(0)
    b.pop(0)
    a_card = [a.count(4), a.count(3), a.count(2), a.count(1)]
    b_card = [b.count(4), b.count(3), b.count(2), b.count(1)]

    if a_card[0] > b_card[0]:
        print("A")
    elif a_card[0] < b_card[0]:
        print("B")
    elif a_card[1] > b_card[1]:
        print("A")
    elif a_card[1] < b_card[1]:
        print("B")
    elif a_card[2] > b_card[2]:
        print("A")
    elif a_card[2] < b_card[2]:
        print("B")
    elif a_card[3] > b_card[3]:
        print("A")
    elif a_card[3] < b_card[3]:
        print("B")
    else:
        print("D")