/*
8. What is the effect of
import java._
import javax._
Is this a good idea?
 */

//first one imports all memebers of the java package
//second imports all members of the javax package
//such wildcard imports are not very useful
//because such top level packages themselves dont contain any useful classes of variables
//and it only basically give direct access to direct subpackages of those packages. Not very useful.
object testPackageWildcardImports {
  val c = new Point()
}
