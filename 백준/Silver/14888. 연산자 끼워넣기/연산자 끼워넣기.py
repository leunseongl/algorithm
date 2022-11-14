import sys
input = sys.stdin.readline

def DFS(l, tot, plus, minus, mul, div):
    global small, big
    if l == n:
        small = min(small, tot)
        big = max(big, tot)
        return

    if plus:
        DFS(l+1, tot+li[l], plus-1, minus, mul, div)
    if minus:
        DFS(l+1, tot-li[l], plus, minus-1, mul, div)
    if mul:
        DFS(l+1, tot*li[l], plus, minus, mul-1, div)
    if div:
        DFS(l+1, int(tot/li[l]), plus, minus, mul, div-1)

n = int(input())
li = list(map(int, input().split()))
a,b,c,d = map(int, input().split())
small = 1e9
big = -1e9

DFS(1,li[0],a,b,c,d)
print(big)
print(small)
