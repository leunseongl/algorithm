a = int(input())

for i in range(a):
  r, s = input().split()
  r = int(r)
  s = str(s)
  for i in range(len(s)):
    print(s[i]*r,end='')
  print()