package org.alma.gl.command

import org.alma.gl.{Invoker, SelectionMultipleStrategy, SelectionUniqueStrategy, Workspace}
import org.junit.{Assert, Before, Test}

/**
 * Created on 02/12/14.
 *
 * @author dralagen, thecreator
 */
class WriteTest {

  var workspace:Workspace = null

  @Before
  def setUp(): Unit = {
    workspace = new Workspace()

    workspace.setContent("Cou World!")

  }

  @Test
  def executeSelectionUniqueTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Write(
        new SelectionUniqueStrategy(workspace, 3),
        "cou"
      )
    )

    Assert.assertEquals("Add content with selection unique", "Coucou World!", workspace.getContent())
  }

  @Test
  def executeSelectionMultipleTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Write(
        new SelectionMultipleStrategy(workspace, 0, 3),
        "Hello"
      )
    )

    Assert.assertEquals("Add content with selection multiple", "Hello World!", workspace.getContent())

  }

  @Test
  def undoSelectionUniqueTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Write(
        new SelectionUniqueStrategy(workspace, 3),
        "cou"
      )
    )

    Assert.assertEquals("Add content with selection unique", "Coucou World!", workspace.getContent())

    Invoker.undo()

    Assert.assertEquals("Undo Write with selection unique", "Cou World!", workspace.getContent())


  }

  @Test
  def undoSelectionMultipleTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Write(
        new SelectionMultipleStrategy(workspace, 0, 3),
        "Hello"
      )
    )

    Assert.assertEquals("Add content with selection multiple", "Hello World!", workspace.getContent())

    Invoker.undo()

    Assert.assertEquals("Undo Write with selection multiple", "Cou World!", workspace.getContent())

  }

}
