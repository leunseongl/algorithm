T=int(input())
ans=""
for test_case in range(1,T+1):
    A,B,C,D=map(int,input().split())
    res=max(0,min(B,D)-max(A,C))
    ans+=f'#{test_case} {res}\n'

print(ans,end='')