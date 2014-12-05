package org.alma.gl

import java.util.List

import org.alma.gl.command.Command
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
      return clip
  }
  override def undo(c: Clipboard, selectContent:String): Unit = {

  }
}