package org.alma.gl

import org.alma.gl.command.{Delete, Command, Write}

/**
 * Created on 10/11/14.
 *
 * @author dralagen
 */
object Core {

  def main(args: Array[String]) {
    val workspace: Workspace = new Workspace()
    println(workspace.getContent())
    var select: Selection = new SelectionUniqueStrategy(workspace,3)
    var cmd: Command = new Write(select, "cou")
    Invoker.invokeCommand(cmd)
    Invoker.invokeCommand(cmd)
    println(workspace.getContent())


    select = new SelectionUniqueStrategy(workspace, 6)
    cmd = new Write(select, " World")
    Invoker.invokeCommand(cmd)
    println(workspace.getContent())
    println(" undo write selectionUnique")
    Invoker.undo()
    println(workspace.getContent())

    select = new SelectionMultipleStrategy(workspace, 0, 6)
    cmd = new Write(select, "Hello")
    Invoker.invokeCommand(cmd)
    println(workspace.getContent())
    println(" undo write selectionMultiple")
    Invoker.undo()
    println(workspace.getContent())

    select = new SelectionUniqueStrategy(workspace, 5)
    cmd = new Delete(select)
    Invoker.invokeCommand(cmd)
    println(workspace.getContent())
    println (" undo delete selectionUnique")
    Invoker.undo()
    println(workspace.getContent())

    select = new SelectionMultipleStrategy(workspace, 3,6)
    cmd = new Delete(select)
    Invoker.invokeCommand(cmd)
    println(workspace.getContent())
    Invoker.undo()
    println(" undo delete selectionMultiple")
    println(workspace.getContent())
  }
}
