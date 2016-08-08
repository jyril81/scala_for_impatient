/*
6. In the Java AWT library, we have a class Container, a subclass of Component that collects multiple
components. For example, a Button is a Component, but a Panel is a Container. That’s the composite
pattern at work. Swing has JComponent and JContainer, but if you look closely, you will notice
something strange. JComponent extends Container, even though it makes no sense to add other
components to, say, a JButton.
 */
//Facts in question are not corret - Swing does not have any class or interface called JContainer in java 1.8.0_66

//Hot is is actually in java 1.8:
//container extends component
//jcomponent extends container
//jbutton extends jcomponent
//jpanel extends jcomponent


//My first attempt to fix it:
//jcomponent extends component
//jcontainer extends container
//jbutton extends jcomponent
//jpanel extends jcontainer

//looks great, but then jcontainer is not jcomponent and hierarchy is not complete nor logical ...


//Horstmann suggeted design:
//container extends component
//jcomponent extends component
//jcomponent extends container
//jcontainer extends container
//jbutton extends jcomponent
//jpanel extends jcontainer

//here problem is that java does not allow multiple inhertance - jcomponent cannot extend both component and container.
//It is basically diamond problem.

//In scala i would make both jcomponent and jcontainer traits:
trait jcomponent extends java.awt.Component

trait jcontainer extends java.awt.Container with jcomponent

class jbutton extends jcomponent

class jpanel extends jcontainer

