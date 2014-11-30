package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
abstract class Selection {
  protected var start: Int = 0
  protected var end: Int = 0
  protected var buffer: Workspace = null

  def getStart: Int = {
    start
  }

  def setStart(start: Int): Unit =
    this.start = start


  def getEnd: Int = end


  def setEnd(end: Int) = this.end = end

  def getContent: String = {
    val str: String = buffer.getContent()
        
    str.substring(start,end)
  }

  def write(cli: Clipboard) = 
  {
      buffer.setContent(cli.getContent())
  }

  def read:Clipboard = ???
}