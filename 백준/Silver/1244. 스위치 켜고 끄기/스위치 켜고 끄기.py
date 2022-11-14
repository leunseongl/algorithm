import sys
input = sys.stdin.readline

switch_n = int(input())
switch = list(map(int, input().split()))
switch.insert(0,0)
student_n = int(input())
for _ in range(student_n):
    a, b = map(int, input().split())
    if a == 1:
        for i in range(b, switch_n+1):
            if abs(i%b) == 0:
                if switch[i] == 0:
                    switch[i] = 1
                else:
                    switch[i] = 0
    else: #여자일 때
        # if switch[b] == 0:
        #     switch[b] = 1
        # else:
        #     switch[b] = 0
        for k in range(switch_n//2):
            if b+k> switch_n or b-k<1 :
                break
            if switch[b-k] != switch[b+k]:
                break
            else:
                if switch[b-k] == 0:
                    switch[b-k] = 1
                    switch[b+k] = 1
                else:
                    switch[b-k] = 0
                    switch[b+k] = 0

for i in range(1, switch_n+1):
    print(switch[i], end=' ')
    if i % 20 == 0:
        print()