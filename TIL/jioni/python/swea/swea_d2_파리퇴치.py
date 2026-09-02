import sys; sys.stdin=open('input.txt','r')

T = int(input())
for tc in range(1,T+1):
    # 입력 시작
    # 변수 초기화
    N,M=map(int,input().split())
    # NN = []
    # for _ in range(N):
    #     NN.append(list(map(int, input().split())))
    NN=[list(map(int,input().split())) for _ in range(N)]

    # 최대합 찾기
    max_fly = 0
    # NN을 r, c로 순환하여 각 위치를 기준점으로 한다
    # 기준점에서부터 MM크기로 합을 구한다
    # for r in NN:
    #     data in r:
    for r in range(N):
        for c in range(N):
            sum = 0
            # r, c 고정
            for dr in range(M):
                if r + dr >= N:
                    continue
                for dc in range(M):
                    if c + dc >= N:
                        continue
                    sum += NN[r+dr][c+dc]
            if sum > max_fly:
                max_fly = sum
    print(f"#{tc} {max_fly}")