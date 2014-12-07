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

    Invoker.invokeCommand(new Write(new SelectionUniqueStrategy(workspace, 0), "Bonjour Monde"))

    val listCommand:util.ArrayList[Command] = new util.ArrayList[Command]()

    listCommand.add(new Write(new SelectionUniqueStrategy(workspace, 0), "Hello"))
    listCommand.add(new Write(new SelectionUniqueStrategy(workspace, 5), " World!"))
    //listCommand.add(new Cut(new SelectionMultipleStrategy(workspace, 0,5)))
    //listCommand.add(new Copy(new SelectionMultipleStrategy(workspace, 1,6)))
    //listCommand.add(new Delete(new SelectionMultipleStrategy(workspace, 0,100)))
    listCommand.add(new Write(new SelectionUniqueStrategy(workspace, 0), "Coucou !"))
    //listCommand.add(new Paste(new SelectionUniqueStrategy(workspace, 7)))
    //listCommand.add(new Write(new SelectionMultipleStrategy(workspace, 0, 6), "Hello"))

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
