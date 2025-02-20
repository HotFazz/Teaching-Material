import matplotlib.pyplot as plt
import random
import time

def visualize_sort(values, current=None, next=None):
    colors = ['red' if x==next else 'green' if x==current else 'gray' for x in range(len(values))]
    plt.bar(range(len(values)), values, color=colors)
    plt.show(block=False)
    plt.pause(0.01)
    plt.clf()

def bubble_sort(values):
    n = len(values)
    for i in range(n):
        for j in range(0, n - i - 1):
            visualize_sort(values, j, j+1)
            time.sleep(0.0005)
            if values[j] > values[j + 1]:
                values[j], values[j + 1] = values[j + 1], values[j]
        visualize_sort(values, None, None)

values = [random.randint(1, 100) for _ in range(100)]
bubble_sort(values)