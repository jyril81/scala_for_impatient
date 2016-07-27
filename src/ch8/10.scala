/*
10. The file scala/collection/immutable/Stack.scala contains the definition
Click here to view code image
class Stack[A] protected (protected val elems: List[A])
Explain the meanings of the protected keywords. (Hint: Review the discussion of private
constructors in Chapter 5.)
 */
//first appearance of protected notes constructor visibility
//it means ctor is protected meaning only subclasses can call it (user coode cannot)
//second protected keyword means elems value is protected, whch means that
//elems is accessible in stack subclasses, but not externally