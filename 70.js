//Fibo

var climbStairs = function(n) {
    // Dp : O(n)
    // if (n <=2) return n
    // let pre = 1 , latter = 2, i= 3, ret
    // while (1){
    //     ret = pre + latter
    //     pre = latter
    //     latter = ret
    //     if (i >=n) return ret   
    //     i+=1
    // }
    //Math (logN)
    sqrt5=Math.sqrt(5);
    fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1)
    return fibn/sqrt5
};
