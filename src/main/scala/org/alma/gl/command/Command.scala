package org.alma.gl.command

import org.alma.gl.{Clipboard, Selection}

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
abstract class Command(s : Selection) {
  protected var selection: Selection = s

  def getSelectContent:String = selection.getContent

  def execute(c: Clipboard):Clipboard = ???

  def undo(c: Clipboard, selectContent:String): Unit = {}
}