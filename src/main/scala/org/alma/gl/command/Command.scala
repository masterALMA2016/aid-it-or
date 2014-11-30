package org.alma.gl.command

import org.alma.gl.{Clipboard, Selection}

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Command(s : Selection) {
    protected var clipboard: Clipboard = null
    protected var selection: Selection = s
    def execute() = {
        //clipboard = new Clipboard(selection.getContent())
    }
}