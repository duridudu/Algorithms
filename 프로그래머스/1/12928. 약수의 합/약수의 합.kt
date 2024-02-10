class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var yaksu = 0
        for (i in 1..n) {
            if (n%i==0) {
                yaksu+=i
            }
        }
        answer = yaksu
        return answer
    }
}