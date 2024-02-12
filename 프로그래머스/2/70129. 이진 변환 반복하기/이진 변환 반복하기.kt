class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        var str = s
        var cnt = 0
        var zeros = 0
        while(true) {
            cnt++
            var templength = str.length
            var news = str.replace("0","").length
            zeros += templength - news
            var temp = Integer.toBinaryString(news.toInt())
            str = temp.toString()
            if (temp == "1") {
                break
            } 
        }
        answer = intArrayOf(cnt, zeros)
        
            
        return answer
    }
}