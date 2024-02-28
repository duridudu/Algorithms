class Solution {
    fun solution(arr: IntArray): Double {
        var temp = 0
        for (a in arr)
            temp += a
        
        var answer:Double = 0.0
        answer = temp.toDouble() / arr.size.toDouble()
        println(answer)
        
        return answer
    }
}