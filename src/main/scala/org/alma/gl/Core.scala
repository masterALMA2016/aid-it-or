package org.alma.gl

/**
 * Created on 10/11/14.
 *
 * @author dralagen
 */
object Core {

  def main(args: Array[String]) {
    var select: Selection = new SelectionUniqueState()

    select.setEnd(3)
    println(select.getContent)
  }
}
