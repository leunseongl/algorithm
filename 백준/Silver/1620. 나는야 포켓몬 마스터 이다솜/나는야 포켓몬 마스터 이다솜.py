import sys

n, m = map(int, sys.stdin.readline().split())
pkm = dict()
pkmn = list()

for i in range(1, n+1):
    pk = sys.stdin.readline().rstrip()
    pkmn.append(pk)
    pkm[pk] = i

for _ in range(m):
    quiz = sys.stdin.readline().rstrip()

    if quiz.isdecimal():
        print(pkmn[int(quiz)-1])
    else:
        print(pkm[quiz])
