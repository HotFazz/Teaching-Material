def better_solution(n):
    solutions = 0 
    for a in range(n + 1):
        for b in range(n + 1):
            c = n - (a + b)
            if c >= 0:
                solutions += 1
    return solutions

# Example: Calculating solutions for n from 1 to 10 
for n in range(1, 500):
    print(f"n = {n}, Solutions: {better_solution(n)}")