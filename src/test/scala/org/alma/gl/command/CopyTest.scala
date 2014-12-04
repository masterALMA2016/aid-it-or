package org.alma.gl.command

import org.alma.gl.{SelectionMultipleStrategy, SelectionUniqueStrategy, Invoker, Workspace}
import org.junit.{Assert, Test, Before}

/**
 * Created on 04/12/14.
 *
 * @author dralagen
 */
class CopyTest {
  var workspace:Workspace = null

  @Before
  def setUp(): Unit = {
    workspace = new Workspace()

    workspace.setContent("Cou World!")

  }

  @Test
  def executeSelectionUniqueTest(): Unit = {

    Invoker.invokeCommand(
      new Copy(
        new SelectionUniqueStrategy(workspace, 3)
      )
    )

    Assert.assertEquals("Copy content with selection unique", "Cou World!", workspace.getContent())
    Assert.assertEquals("Copy add content into clipboard", "", Invoker.getContentClipboard)
  }

  @Test
  def executeSelectionMultipleTest(): Unit = {

    Invoker.invokeCommand(
      new Copy(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Assert.assertEquals("Copy content with selection multiple", "Cou World!", workspace.getContent())
    Assert.assertEquals("Copy add content into clipboard", "Cou", Invoker.getContentClipboard)

  }

  @Test
  def executeSelectionMultipleAndUnique(): Unit = {

    Invoker.invokeCommand(
      new Copy(
        new SelectionMultipleStrategy(workspace, 4, 9)
      )
    )

    Assert.assertEquals("Copy content with selection multiple", "Cou World!", workspace.getContent())
    Assert.assertEquals("Copy add content into clipboard", "World", Invoker.getContentClipboard)

    Invoker.invokeCommand(
      new Copy(
        new SelectionUniqueStrategy(workspace, 0)
      )
    )

    Assert.assertEquals("Copy content with selection multiple", "Cou World!", workspace.getContent())
    Assert.assertEquals("Copy add content into clipboard", "", Invoker.getContentClipboard)

  }

  @Test
  def doubleExecuteSelectionMultiple(): Unit = {

    Invoker.invokeCommand(
      new Copy(
        new SelectionMultipleStrategy(workspace, 4, 9)
      )
    )

    Assert.assertEquals("Copy content with selection multiple", "Cou World!", workspace.getContent())
    Assert.assertEquals("Copy add content into clipboard", "World", Invoker.getContentClipboard)

    Invoker.invokeCommand(
      new Copy(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Assert.assertEquals("Copy content with selection multiple", "Cou World!", workspace.getContent())
    Assert.assertEquals("Copy add content into clipboard", "Cou", Invoker.getContentClipboard)

  }

  @Test
  def undoSelectionUniqueTest(): Unit = {

    Invoker.invokeCommand(
      new Copy(
        new SelectionMultipleStrategy(workspace, 4, 9)
      )
    )

    Invoker.invokeCommand(
      new Cut(
        new SelectionUniqueStrategy(workspace, 3)
      )
    )

    Invoker.undo()

    Assert.assertEquals("Undo Copy with selection unique", "Cou World!", workspace.getContent())
    Assert.assertEquals("Copy undo content into clipboard", "World", Invoker.getContentClipboard)


  }

  @Test
  def undoSelectionMultipleTest(): Unit = {

    Invoker.invokeCommand(
      new Copy(
        new SelectionMultipleStrategy(workspace, 4, 9)
      )
    )

    Invoker.invokeCommand(
      new Cut(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Invoker.undo()

    Assert.assertEquals("Undo Copy with selection multiple", "Cou World!", workspace.getContent())
    Assert.assertEquals("Copy undo content into clipboard", "World", Invoker.getContentClipboard)

  }
}
