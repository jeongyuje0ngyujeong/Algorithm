import sys
from collections import defaultdict

size = int(sys.stdin.readline())
graph = defaultdict(list)
check_order = []


def pre_order(key):
    if key == '.':
        return

    check_order.append(key)
    pre_order(graph[key][0])
    pre_order(graph[key][1])


def order(key):
    if key == '.':
        return

    order(graph[key][0])
    check_order.append(key)
    order(graph[key][1])


def post_order(key):
    if key == '.':
        return

    post_order(graph[key][0])
    post_order(graph[key][1])
    check_order.append(key)


for i in range(size):
    k, b, c = map(str, sys.stdin.readline().split())
    graph[k].extend([b, c])

pre_order('A')
sys.stdout.write(''.join(check_order) + "\n")
check_order.clear()

order('A')
sys.stdout.write(''.join(check_order) + "\n")
check_order.clear()

post_order('A')
sys.stdout.write(''.join(check_order) + "\n")
