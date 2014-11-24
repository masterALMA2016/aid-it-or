package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Copy extends Command {
    def execute = {
        this.clipboard = this.selection.read()
    }
}
