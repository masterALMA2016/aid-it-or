package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Paste extends Command {
    def execute{
        this.selection.write(this.clipboard);
    }
}
