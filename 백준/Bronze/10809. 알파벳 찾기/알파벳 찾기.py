from string import ascii_lowercase
a = input()
alphabet_list = list(ascii_lowercase)

for i in alphabet_list:
  print(a.find(i),end=' ')