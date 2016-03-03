package org.scalacourse

import com.synergygb.zordon.common.data.DataTransformContext
import com.synergygb.zordon.core.ServiceBoot
import com.synergygb.zordon.gen.models.Project
import com.synergygb.zordon.gen.routes.ApplicationRoutesConsolidated
import org.scalacourse.Models.ProjectResponse
import spray.routing.Route

object Boot extends App with ServiceBoot with ApplicationRoutesConsolidated {

  import Context.keyValueStore
  implicit def context = Context

  override def dataContext: DataTransformContext = context

  protected def apiResourceClass = getClass

  override def handlePostProject(create: Project)(): Route = {
    keyValueStore.write("gvproject" + create.id, create)
    complete(ProjectResponse("Project saved"))

  }

  override def handlePutProjectId(id: String, create: Project)(): Route = {
    keyValueStore.write("gvproject" + id, create)
    complete(ProjectResponse("Project updated"))


  }

  override def handleDeleteProjectId(id: String)(): Route = { id =>
    keyValueStore.delete("gvproject" + id)
    complete(ProjectResponse("Project Deleted"))
  }

}
