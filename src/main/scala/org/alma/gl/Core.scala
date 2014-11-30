package org.alma.gl

import org.alma.gl.command.Write

/**
 * Created on 10/11/14.
 *
 * @author dralagen
 */
object Core {

  def main(args: Array[String]) {
    var workspace: Workspace = new Workspace()
    println(workspace.getContent())
    var select: Selection = new SelectionUniqueState(workspace,3)
    var invoker: Invoker = new Invoker()
    var write: Write = new Write(select, "cou")
    invoker.invokeCommand(write)
    invoker.invokeCommand(write)
    println(workspace.getContent())


    select = new SelectionUniqueState(workspace, 6)
    write = new Write(select, " World")
    invoker.invokeCommand(write)
    println(workspace.getContent())

    select = new SelectionMultipleState(workspace, 0, 6)
    write = new Write(select, "Hello")
    invoker.invokeCommand(write)
    println(workspace.getContent());


    /*
    invoker.undo(write)
    println(workspace.getContent())
    */
  }
}
