package org.alma.gl

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
    var write: Write = new Write(select, "coucou")
    invoker.invokeCommand(write)
    println(workspace.getContent())/*
    invoker.undo(write)
    println(workspace.getContent())*/
  }
}
