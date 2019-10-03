package org.thp.thehive.connector.cortex.controllers.v0

import scala.language.implicitConversions

import io.scalaland.chimney.dsl._
import org.thp.cortex.dto.v0.CortexOutputArtifact
import org.thp.thehive.models.Observable

object ArtifactConversion {

  implicit def fromCortexOutputArtifact(j: CortexOutputArtifact): Observable =
    j.into[Observable]
      .withFieldComputed(_.message, _.message)
      .withFieldComputed(_.tlp, _.tlp)
      .withFieldConst(_.ioc, false)
      .withFieldConst(_.sighted, false)
      .transform
}
