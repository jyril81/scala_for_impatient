/*
3. Look at the BitSet class, and make a diagram of all its superclasses and traits. Ignore the type
parameters (everything inside the [...]). Then give the linearization of the traits.
 */

//trait BitSet extends SortedSet[Int] with BitSetLike[BitSet]
BitSet >> lin(BitSetLike) >> lin(SortedSet)
//replace BitSetLike and SortedSet
BitSet >> (BitSetLike >> SortedSetLike) >> (SortedSet >> SortedSetLike >> Set)
//remove first occurrence of SortedSetLike
BitSet >> BitSetLike >> SortedSet >> SortedSetLike >> Set
//replace Set
BitSet >> BitSetLike >> SortedSet >> SortedSetLike >> SetLike >> Sorted >> Set
//not much point to go deeper from here