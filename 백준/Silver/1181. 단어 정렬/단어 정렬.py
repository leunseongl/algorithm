n = int(input())
word = set()
for _ in range(n):
    word.add(input())
    
word = list(word)
word.sort()
word.sort(key = len)

for i in word:
    print(i)