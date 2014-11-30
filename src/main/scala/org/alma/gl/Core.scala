package org.alma.gl

import org.alma.gl.command.{Delete, Command, Write}

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
    var cmd: Command = new Write(select, "cou")
    invoker.invokeCommand(cmd)
    invoker.invokeCommand(cmd)
    println(workspace.getContent())


    select = new SelectionUniqueState(workspace, 6)
    cmd = new Write(select, " World")
    invoker.invokeCommand(cmd)
    println(workspace.getContent())

    select = new SelectionMultipleState(workspace, 0, 6)
    cmd = new Write(select, "Hello")
    invoker.invokeCommand(cmd)
    println(workspace.getContent())

    select = new SelectionUniqueState(workspace, 5)
    cmd = new Delete(select)
    invoker.invokeCommand(cmd)
    println(workspace.getContent())

    cmd = new Write(select, " ")
    invoker.invokeCommand(cmd)

    select = new SelectionMultipleState(workspace, 0,6)
    cmd = new Delete(select)
    invoker.invokeCommand(cmd)
    println(workspace.getContent())


    /*
    invoker.undo(write)
    println(workspace.getContent())
    */
  }
}
