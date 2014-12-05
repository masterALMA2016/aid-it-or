package org.alma.gl.command

import org.alma.gl.{Clipboard, Selection}

/**
 * Created on 24/11/14.
 *
 * @author dralagen, thecreator
 */
class Copy(s: Selection) extends Command(s) {
    override def execute(clipboard:Clipboard):Clipboard = {
        this.selection.read
    }
}
