/*
1. According to the precedence rules, how are 3 + 4 -> 5 and 3 -> 4 + 5 evaluated?
 */
//Evaluation order is defined by assoativity
//Associativity applies only to operators of same precedennce
//In scala, operator precedence is defined by the first character of the operator
//in both expressions all operators have first character either + or -
//+ and - belong ti the same precedence group
//+ and - are left associative. This we get
// 3 + 4 -> 5 is same as (3 + 4) -> 5
//3 -> 4 + 5 is same as (3 -> 4) + 51