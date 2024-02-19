import matplotlib.pyplot as plt
import random
import time

def visualize_sort(values, current=None, min_idx=None):
    colors = ['green' if x==min_idx else 'red' if x==current else 'gray' for x in range(len(values))]
    plt.bar(range(len(values)), values, color=colors)
    plt.show(block=False)
    plt.pause(0.1)
    plt.clf()

def selection_sort(values):
    n = len(values)
    for i in range(n):
        min_idx = i
        for j in range(i+1, n):
            visualize_sort(values, j, min_idx)
            time.sleep(0.05)
            if values[j] < values[min_idx]:
                min_idx = j
        values[i], values[min_idx] = values[min_idx], values[i]
        visualize_sort(values, None, None)

values = [random.randint(1, 100) for _ in range(100)]
selection_sort(values)