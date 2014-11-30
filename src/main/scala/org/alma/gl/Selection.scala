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

  def write(cli: Clipboard): Unit = {
    val content: String = buffer.getContent()
    var before: String = ""
    var after: String = ""
    
    if (start <= content.length()) {
      before = content.substring(0, start)
      if (end < content.length()) {
        after = content.substring(end, content.length())
      }
    } else {
      before = content
    }
      
    buffer.setContent(before + cli.getContent() + after)
  }

  def delete(): Unit

  def read:Clipboard = ???
}