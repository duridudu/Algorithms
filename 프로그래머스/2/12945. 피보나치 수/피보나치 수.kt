class Solution {
    fun solution(n: Int): Int {
        var array = Array(n+1){0}
        array[0] = 0
        array[1] = 1
        for (i in 2..n) {
            array[i] = ((array[i-1])%1234567 + (array[i-2])%1234567)%1234567
        }
        
       return array[n]
    }

}