package org.alma.gl

import org.alma.gl.command.Command

/**
 * Created on 01/12/14.
 *
 * @author dralagen, thecreator
 */
class CommandHistory(cmd:Command, preClip:Clipboard) {
  val command:Command = cmd
  val preClipboard:Clipboard = preClip
  val selectionContent:String = cmd.getSelectContent
  var postClipboard: Clipboard = null

  def setPostClipboard(clip:Clipboard): Unit = {
    postClipboard = clip
  }

  def undo():Clipboard = {
    cmd.undo(postClipboard, selectionContent)
    preClipboard
  }
}
