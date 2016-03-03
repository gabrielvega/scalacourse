package org.scalacourse

import spray.json.DefaultJsonProtocol._

object Models {

  implicit val projectFormat = jsonFormat1(ProjectResponse)
  //implicit val taskFormat = jsonFormat3(Task)

  case class ProjectResponse(name: String)
  //case class Task(name : String, user: String, status: String)

}