package org.alma.gl

import java.util

import org.alma.gl.command.Command

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
object Invoker {
  private val history: util.List[CommandHistory] = new util.ArrayList[CommandHistory]()
  private var clipboard: Clipboard = null


  def invokeCommand(cmd:Command)={
      val cmdHistory = new CommandHistory(cmd, clipboard)
      clipboard = cmd.execute(clipboard)
      cmdHistory.setPostClipboard(clipboard)
      history.add(cmdHistory)
      clipboard
  }

  def undo() = {
    val index:Int = history.size()-1
    if (index >= 0) {
      val cmd: CommandHistory = history.get(index)
      cmd.undo()

      clipboard = cmd.preClipboard

      history.remove(index)
    }
  }
}