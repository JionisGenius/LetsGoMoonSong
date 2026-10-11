# 16 진수 to 2진수 문제
# 16 -> 10 -> 2 진수로 바꿔야한다
# int(16str,16) # 10 진수 변환
# bin(dec_num) # 2진수 변환
# print (bin_list[2:]) # 0b 접두사 제외 

# T=int(int(input()))
# for tc in range(1,T+1):
#     N,hex=input().strip()
#     N=int(N)
#     dec=int(hex,16)
#     ans=bin(dec)[2:]
#     ans =ans.zfill(N*4)
#     print(f'#{tc} {ans}')

# T = int(input())

# for tc in range(1, T + 1):
#     N, hex = input().split()

#     ans = ''
#     for ch in hex:
#         ans += format(int(ch, 16), '04b')

#     print(f'#{tc} {ans}')
    
T= int(input())
for tc in range(1,T+1):
    N,hex= input().split()
    arr = ''
    for i in hex:
        arr+=format((int,16),'04b')
    print(f'#{tc}{arr}')
        