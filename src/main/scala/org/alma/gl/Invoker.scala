package org.alma.gl

import java.util

import org.alma.gl.command.Command

/**
 * Created on 24/11/14.
 *
 * @author dralagen, thecreator
 */
object Invoker {
  private val history: util.List[CommandHistory] = new util.ArrayList[CommandHistory]()
  private var clipboard: Clipboard = null


  def invokeCommand(cmd:Command):Unit = {
      val cmdHistory = new CommandHistory(cmd, clipboard)
      clipboard = cmd.execute(clipboard)
      cmdHistory.setPostClipboard(clipboard)
      history.add(cmdHistory)
  }

  def undo():Unit = {
    val index:Int = history.size()-1
    if (index >= 0) {
      val cmd: CommandHistory = history.get(index)
      history.remove(index)
      cmd.undo()

      clipboard = cmd.preClipboard
    }
  }

  def getContentClipboard:String = {
    if (clipboard == null) {
      ""
    } else {
      clipboard.getContent()
    }
  }
}