
package views.html.event

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object modalDelete extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="modalDeleteEvent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">

        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" data-bind="text: event().name()"></h4>
            </div>
            <div class="modal-body">
            """),_display_(/*13.14*/Messages("p.deleteEvent")),format.raw/*13.39*/("""
            """),format.raw/*14.13*/("""</div>

            <div class="modal-footer">
                <div class="pull-left">
                    <button type="button" class="btn btn-danger" data-bind="click: delet">"""),_display_(/*18.92*/Messages("btn.delete")),format.raw/*18.114*/("""</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">"""),_display_(/*19.89*/Messages("btn.back")),format.raw/*19.109*/("""</button>
                </div>
            </div>

        </div>

    </div>
</div>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Mar 20 13:13:41 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/modalDelete.scala.html
                  HASH: 5bf2414fc07a15652a6d3f532dc49307646d0f21
                  MATRIX: 810->0|1409->572|1455->597|1497->611|1706->793|1750->815|1876->914|1918->934
                  LINES: 29->1|41->13|41->13|42->14|46->18|46->18|47->19|47->19
                  -- GENERATED --
              */
          