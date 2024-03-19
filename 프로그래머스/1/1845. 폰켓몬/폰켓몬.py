def solution(nums):
    pocket = set(nums)
    if len(pocket) <= len(nums)//2:
        return len(pocket)
    else:
        return len(nums)//2
    return