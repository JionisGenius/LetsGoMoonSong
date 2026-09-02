import sys; sys.stdin=open('input.txt') 

T=int(input())
for tc in range(1,T+1):
    # 입력 시작
    N=int(input())
    # data[0] = [r1, c1, r2, c2, color]
    data=[list(map(int,input().split())) for _ in range(N)]
    # 입력 끝
    # 배열영역 만들기 (0 = 빈색, 1 = 빨간색, 2 = 파란색, 3 = 보라색)
    NN = [[0]*10 for _ in range(10)]

    # 답
    answer = 0
    # 데이터 순환
    # 아무것도 없으면 해당영역 그 색으로 칠하기
    # 있으면
    ## 같은 색이면 놔두기 = 구현 안하면 됨
    ## 다른 색이면 보라색으로 만들기
    for d in data:
        for r in range(d[0], d[2]+1):
            for c in range(d[1], d[3]+1):
                if NN[r][c] == 0: # 비어있다
                    NN[r][c] = d[4]
                elif NN[r][c] != d[4]: # 다른색이다
                    if NN[r][c] != 3: # 보라색이 아니면
                        NN[r][c] = 3 # 보라색으로 만들고
                        answer += 1  # 보라색 칠한 숫자 ++

    print(f"#{tc} {answer}")