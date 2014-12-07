package org.alma.gl

import java.util

import org.alma.gl.command._

/**
 * Created on 10/11/14.
 *
 * @author dralagen, thecreator
 */
object Core {

  def main(args: Array[String]) {
    val workspace: Workspace = new Workspace()
    val listCommand:util.ArrayList[Command] = new util.ArrayList[Command]()

    listCommand.add(new Write(new SelectionUniqueStrategy(workspace, 0), "Hello"))
    listCommand.add(new Write(new SelectionUniqueStrategy(workspace, 5), " World!"))
    listCommand.add(new Write(new SelectionMultipleStrategy(workspace, 0, 5), "Coucou"))
    Invoker.invokeCommand(
      new Macro(
        new SelectionUniqueStrategy(workspace, 0),
        listCommand
      )
    )

    println(workspace.getContent())

    Invoker.undo()

    System.out.println(workspace.getContent())
  }
}
