import sys; sys.stdin = open("input.txt")

for _ in range(1, 11):
    # 입력 부분
    tc = input()
    matrix = [[0]*100 for _ in range(100)]
    for i in range(100):
        matrix[i] = list(map(int, input().split()))
    # 풀이 부분
    answer = -(2**31)
    # 행
    for r in range(100):
        temp = 0
        for c in range(100):
            temp += matrix[r][c]
        if temp > answer:
            answer = temp
    # 열
    for c in range(100):
        temp = 0
        for r in range(100):
            temp += matrix[r][c]
        if temp > answer:
            answer = temp
    # 대각 ↘
    temp = 0
    for i in range(100):
        temp += matrix[i][i]
    if temp > answer:
        answer = temp
    # 대각 ↗
    temp = 0
    for i in range(100):
        temp += matrix[i][99-i]
    if temp > answer:
        answer = temp

    print(f"#{tc} {answer}")