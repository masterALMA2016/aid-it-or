package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Command {
    protected var clipboard: Clipboard = null
    protected var selection: Selection = null
    def execute(clp: Clipboard): Clipboard = {
        clipboard = new Clipboard(selection.getContent())
    }
}