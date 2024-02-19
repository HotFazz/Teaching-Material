import matplotlib.pyplot as plt
import random
import time

def visualize_sort(values, left=None, right=None):
    colors = ['green' if left <= x <= right else 'gray' for x in range(len(values))]
    plt.bar(range(len(values)), values, color=colors)
    plt.show(block=False)
    plt.pause(0.1)
    plt.clf()

def merge_sort(values, left=0, right=None):
    if right is None:
        right = len(values) - 1

    if left < right:
        middle = (left + right) // 2
        merge_sort(values, left, middle)
        merge_sort(values, middle + 1, right)
        merge(values, left, middle, right)

def merge(values, left, middle, right):
    visualize_sort(values, left, right)
    time.sleep(0.1)

    left_copy = values[left:middle + 1]
    right_copy = values[middle + 1:right + 1]

    left_copy_index = 0
    right_copy_index = 0
    sorted_index = left

    while left_copy_index < len(left_copy) and right_copy_index < len(right_copy):
        if left_copy[left_copy_index] <= right_copy[right_copy_index]:
            values[sorted_index] = left_copy[left_copy_index]
            left_copy_index = left_copy_index + 1
        else:
            values[sorted_index] = right_copy[right_copy_index]
            right_copy_index = right_copy_index + 1

        sorted_index = sorted_index + 1

    while left_copy_index < len(left_copy):
        values[sorted_index] = left_copy[left_copy_index]
        left_copy_index = left_copy_index + 1
        sorted_index = sorted_index + 1

    while right_copy_index < len(right_copy):
        values[sorted_index] = right_copy[right_copy_index]
        right_copy_index = right_copy_index + 1
        sorted_index = sorted_index + 1

values = [random.randint(1, 100) for _ in range(100)]
merge_sort(values)