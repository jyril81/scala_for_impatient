import scala.beans.BeanProperty

/*
Make a class Student with read-write JavaBeans properties name (of type String)
and id (of type Long). What methods are generated? (Use javap to check.)
 Can you call the JavaBeans getters and
setters in Scala Should you?
 */
class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {

}

val jyril: Student = new Student("jyril", 66)
jyril.setName("newname")
/*
Following code is generated:
Compiled from "exer5.scala"
public class Student {
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public void setName(java.lang.String);
  public long id();
  public void id_$eq(long);
  public void setId(long);
  public java.lang.String getName();
  public long getId();
  public Student(java.lang.String, long);
}
Generated bean property methods are accessible from scala code as well
 */