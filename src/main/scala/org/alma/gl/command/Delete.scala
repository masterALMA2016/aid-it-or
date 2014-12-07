package org.alma.gl.command

import org.alma.gl.{Workspace, SelectionUniqueStrategy, Clipboard, Selection}

/**
 * Created on 24/11/14.
 *
 * @author dralagen, thecreator
 */
class Delete(s: Selection) extends Command(s) {


    override def getSelectContent: String = {
        var selectionContent: String = selection.getContent
        if (selectionContent == "") {
            selection.verifySelection()
            val ws:Workspace = selection.getWorkspace
            if (selection.getStart > 0 && ws.getContent().length() > 1) {
                selectionContent = ws.getContent().substring(selection.getStart-1,selection.getEnd)
            }
        }
        selectionContent
    }

    override def execute(clipboard:Clipboard): Clipboard ={
        selection.delete()
        clipboard
    }

    override def undo(c: Clipboard, selectContent:String): Unit = {
        var start:Int = selection.getStart
        if (selection.getStart == selection.getEnd && start > 0) {
            start-=1
        }

        val newSelect:Selection = new SelectionUniqueStrategy(selection.getWorkspace, start)

        val cmd:Command = new Write(newSelect, selectContent)

        cmd.execute(c)
    }
}
