t = int(input())
for _ in range(t):
    string = input().split()
    for i in string:
        print(i[::-1], end=' ')
    print()