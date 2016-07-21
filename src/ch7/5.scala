/*
5. What is the meaning of private[com] def giveRaise(rate: Double)? Is it useful?
 */
//Function giveRaise is visible in package com and in all of its subpackages.
//It does not make much sense because it gives quite lot visibility and restriction is really meaningless
//below code demonstrated it

package com.jyril.test5 {

  class test1 {
    private[com] def giveRaise(rate: Double) = {

    }
  }

}

package com.jyril {

  object testA {
    val c = new test1
    c.giveRaise(1.0)
  }

}

package com {

  object testB {
    val c = new test1
    c.giveRaise(1.0)
  }

}

package org.jyril {

  object testC {
    val c = new test1
    //following line wont compile because current package is not com or or subpackage of com
    //c.giveRaise(1.0)
  }

}