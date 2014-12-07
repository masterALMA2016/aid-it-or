package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen, thecreator
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

    if (start >= str.length()) {
      return ""
    } else if (end >= str.length()) {
      return str.substring(start)
    }
    str.substring(start,end)
  }

  def write(cli: Clipboard): Unit = {
    verifySelection()

    val content: String = buffer.getContent()
    var before: String = ""
    var after: String = ""

    if (start <= content.length()) {
      before = content.substring(0, start)
      if (end < content.length()) {
        after = content.substring(end)
      }
    } else {
      before = content
    }

    buffer.setContent(before + cli.getContent() + after)
  }

  def getWorkspace: Workspace = {
    buffer
  }

  def delete(): Unit

  def read():Clipboard

  def cut(): Clipboard

  def verifySelection():Unit
}
