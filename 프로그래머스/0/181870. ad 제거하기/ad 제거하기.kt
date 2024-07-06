class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        
        for (str in strArr) {
            if (!str.contains("ad")) {
                answer.add(str)
            }
        }
        
        return answer.toTypedArray()
    }
}
