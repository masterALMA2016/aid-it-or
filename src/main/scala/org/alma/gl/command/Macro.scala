package org.alma.gl.command

import java.util.List

import org.alma.gl.{Clipboard, Invoker, Selection}

import scala.collection.JavaConversions._

/**
 * Created on 24/11/14.
 *
 * @author dralagen, thecreator
 */
class Macro(s:Selection, commandList: List[Command]) extends Command(s:Selection) {
  var commands: List[Command] = commandList

  override def execute(c: Clipboard):Clipboard = {
    for(cmd:Command <- commands.toList)
    {
      Invoker.invokeCommand(cmd)
    }
    c
  }
  override def undo(c: Clipboard, selectContent:String): Unit = {
    for (cmd:Command <- commands.toList) {
      Invoker.undo()
    }
  }
}