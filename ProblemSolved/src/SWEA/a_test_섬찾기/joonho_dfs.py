T = int(input())
# 전역 변수
matrix =[] #지도
visited = [] #방문 여부
# 상하좌우
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

# TestCase
for tc in range(1, T+1):
    # Input
    N, M = map(int, input().split());
    # Init
    matrix=[list(input()) for _ in range(N)]
    visited=[[False]*M for _ in range(N)]
    cnt = 0

    for r in range(N):
        for c in range(M):
            if visited[r][c]==False and matrix[r][c]=="L":
                dfs(r, c)
                cnt += 1

    print(f'#{tc} {cnt}')


def dfs(r, c):
    # 도장 찍기 준호 다녀감~
    visited[r][c]=True
    # 1. 제한 부분
    # 없음
    # 2. 재귀 부분
    for d in range(4):
        nr, nc = r+dr[d], c+dc[d]
        if nr < 0 or nr >= N or nc < 0 or nc >= M:
            continue
        dfs(nr, nc)