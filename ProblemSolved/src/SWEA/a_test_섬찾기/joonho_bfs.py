from collections import deque

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

T = int(input())
for tc in range(1, T+1):
    # Input, Init
    N, M = map(int, input().split())
    matrix = [list(input()) for _ in range(N)]
    visited = [[False for _ in range(M)] for _ in range(N)]
    cnt = 0

    # 모든섬
    for r in range(N):
        for c in range(M):
            # BFS
            if visited[r][c]==False and matrix[r][c] == "L": # 섬에 온 적이 없다면
                queue = deque([(r, c)]) # 현재 큐에 넣는다
                cnt += 1 # 섬 갯수 +1
                # 주변 이어진 섬 탐색 시작
                while queue: # 큐가 비어있으면 이어진 섬들을 다 처리한 것
                    # 현재 땅
                    cur_r, cur_c = queue.popleft() # 이어진 섬 중 큐에 첫빠따 꺼내기
                    visited[r][c] = True # 도장찍기
                    # 다음 땅
                    for d in range(4): # 4 방향 체크
                        nr, nc = cur_r+dr[d], cur_c+dc[d]
                        if nr < 0 or nr >= N or nc < 0 or nc >= M: #  바운더리 체크
                            continue
                        if visited[nr][nc]==False and matrix[nr][nc] == "L":
                            queue.append((nr, nc)) # 큐에 이어진 섬 추가

    print(f'#{tc} {cnt}')