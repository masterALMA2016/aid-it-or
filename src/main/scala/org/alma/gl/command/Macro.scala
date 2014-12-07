package org.alma.gl.command

import java.util
import java.util.List

import org.alma.gl.{Clipboard, Selection}

import scala.collection.JavaConversions._

/**
 * Created on 24/11/14.
 *
 * @author dralagen, thecreator
 */
class Macro(s:Selection, commandList: List[Command]) extends Command(s:Selection) {
  var commands: List[Command] = commandList

  override def execute(c: Clipboard):Clipboard = {
      var clip:Clipboard = c
      for(cmd:Command <- commands.toList)
      {
          clip = cmd.execute(clip)
      }
      clip
  }
  override def undo(c: Clipboard, selectContent:String): Unit = {

    undoMacro(new util.ArrayList[Command](commands), c, selectContent)
  }

  private def undoMacro(commands:List[Command], c: Clipboard, selectContent:String): Unit = {

    if (commands.length > 0) {
      val myCmd:Command = commands.get(0)
      commands.remove(0)
      undoMacro(commands, c, selectContent)
      myCmd.undo(c, selectContent)
    }

  }
}