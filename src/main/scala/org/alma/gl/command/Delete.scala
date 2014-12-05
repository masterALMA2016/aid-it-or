package org.alma.gl.command

import org.alma.gl.{SelectionUniqueStrategy, Clipboard, Selection}

/**
 * Created on 24/11/14.
 *
 * @author dralagen, thecreator
 */
class Delete(s: Selection) extends Command(s) {
    var deleteText:String = null
    override def execute(clipboard:Clipboard): Clipboard ={
        deleteText=selection.delete()
        clipboard
    }

    override def undo(c: Clipboard, selectContent:String): Unit = {
        var start:Int = selection.getStart
        if (selection.getStart == selection.getEnd && start > 0) {
            start-=1
        }

        val newSelect:Selection = new SelectionUniqueStrategy(selection.getWorkspace, start)

        val cmd:Command = new Write(newSelect, deleteText)

        cmd.execute(c)
    }
}
