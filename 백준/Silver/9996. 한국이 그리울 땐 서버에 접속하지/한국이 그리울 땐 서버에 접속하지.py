n = int(input())
file = list(input().split('*'))
s = file[0]
e = file[1]
for _ in range(n):
    name = input()
    if len(name) >= len(s+e):
        if name[:len(s)] == s and name[-len(e):] == e:
            print('DA')
        else:
            print('NE')
    else:
        print('NE')