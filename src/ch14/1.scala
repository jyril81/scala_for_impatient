/*
1. Your Java Development Kit distribution has the source code for much of the JDK in the src.zip
file. Unzip and search for case labels (regular expression case [^:]+:). Then look for comments
starting with // and containing [Ff]alls? thr to catch comments such as // Falls through or // just
fall thru. Assuming the JDK programmers follow the Java code convention, which requires such
a comment, what percentage of cases falls through?
 */

//first, elst decypher regular expression "case [^:]+:"
//it is "case", followed by space, followed by list of one or more charecters where each character is anything except ":", followed by ":"

//to count cases:
//in my windows 10 machine with git bash the command line is following:
>> / c / Program Files / Java / jdk1 .8.0 _66 / src $ grep -r - E 'case[^:] +: '.| wc -l
10125
// -r makes search recursive
//-E makes search pattern to support extended set of regular expressions
//search term must be in single quotes to avoid shell evaluation before it is passed to grep
//first arg is regular expression, second is top dir for recursive search, in this case current dir

//to count fall through comments:
>> jyril@DESKTOP - FJLK3I0 MINGW64 / c / Program Files / Java / jdk1 .8.0 _66 / src $ grep -r - E '//.*[Ff] alls ? thr '.| wc -l
102

//Thus percentage is 102/10125 = 0.01007 ~ 1 percent. It means that almosr always fall through is something that is NOT wanted
