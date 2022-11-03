def solution(nums):
    li = []
    for i in range(len(nums)):
        for j in range(i+1, len(nums)):
            for k in range(j+1, len(nums)):
                tmp = nums[i] + nums[j] + nums[k]
                li.append(tmp)
    cnt = 0
    for i in li:
        flag = 0
        for j in range(2, i):
            if i%j == 0:
                flag +=1
        if flag == 0:
            cnt += 1
    return cnt