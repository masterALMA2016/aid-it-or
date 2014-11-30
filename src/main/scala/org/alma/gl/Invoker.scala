package org.alma.gl

import java.util.List

import org.alma.gl.command.Command

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Invoker {
  private var history: List[Command] = null
      def invokeCommand(cmd:Command)={
      cmd.execute()
  }
}