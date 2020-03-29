/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
 
 //iterative way with Js would result in overtime
var myPow = function(x, n) {
    if (n == 0 || x ==1) return 1
//      let is_neg = false;
//     if (n < 0) {
//         is_neg = !is_neg;
//         n  = - n;
//     }
    // let ans = 1;
    // while (n) {
    //     if (n & 1) {
    //         ans *= x;
    //     }
    //     x *= x;
    //     n  = n >> 1;
    // }
    // return is_neg === false ? ans : 1/ans;
    
    let is_neg = false;
    if (n < 0) {
        is_neg = !is_neg;
        n  = - n;
    }
    const recur = (x, n) => {
        if (n === 0) return 1;
        const res = recur(x, n/2);
        if (n & 1) {
            return res*res*x;
        } else {
            return res*res;
        }
    }
    const ans = recur(x, n);
    return is_neg === false ? ans : 1/ans;
    
//     let k = 1;
//     let n2= n
//     while ( 1 != n2 )
//     {
//         if( n2 % 2  )
//             k *= x;  //保留中间结果
//         x *= x;
//         n2 = n2>> 1;
//     }
//     return n>0? k*x: 1/(k*x);

};
