package org.alma.gl.command

import org.alma.gl.{Clipboard, Selection}

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Cut(s: Selection) extends Command(s) {
    override def execute(clipboard:Clipboard):Clipboard = {
        clipboard
    }
}
