import sys

size = int(sys.stdin.readline())
words = set([])

for i in range(size):
    words.add(sys.stdin.readline())

words_list = list(sorted(words, key=lambda x: (len(x), x)))

for i in range(len(words_list)):
    sys.stdout.write(words_list[i])
