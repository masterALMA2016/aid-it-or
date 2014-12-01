package org.alma.gl.command

import org.alma.gl.{SelectionUniqueState, Invoker, Clipboard, Selection}

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Delete(s: Selection) extends Command(s) {
    override def execute(clipboard:Clipboard): Clipboard ={
        selection.delete()
        clipboard
    }

    override def undo(c: Clipboard, selectContent:String): Unit = {
        val newSelect:Selection = new SelectionUniqueState(selection.getWorkspace, selection.getStart)

        val cmd:Command = new Write(newSelect, selectContent)

        cmd.execute(c)
    }
}
