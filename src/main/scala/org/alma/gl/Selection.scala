package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
abstract class Selection {
  private var start: Int = 0
  private var end: Int = 0
  private var buffer: Workspace = null

  def getStart: Int = {
    start
  }

  def setStart(start: Int): Unit =
    this.start = start


  def getEnd: Int = end


  def setEnd(end: Int) = this.end = end

  def getContent: String = {
    val str: String = "Hello"

    str.substring(start,end)
  }

  def write(cli: Clipboard) = ???

  def read:Clipboard = ???
}