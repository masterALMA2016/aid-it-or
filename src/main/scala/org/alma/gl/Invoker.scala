package org.alma.gl

import java.util
import java.util.List

import org.alma.gl.command.Command

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
object Invoker {
  private val history: List[CommandHistory] = new util.ArrayList[CommandHistory]()
  private var clipboard: Clipboard = null


  def invokeCommand(cmd:Command)={
      val cmdHistory = new CommandHistory(cmd, clipboard)
      clipboard = cmd.execute(clipboard)
      cmdHistory.setPostClipboard(clipboard)
      history.add(cmdHistory)
      clipboard
  }

  def undo() = {
    val cmd:CommandHistory = history.get(history.size()-1)
    cmd.undo()

    clipboard = cmd.preClipboard

    history.remove(history.size()-1)
  }
}