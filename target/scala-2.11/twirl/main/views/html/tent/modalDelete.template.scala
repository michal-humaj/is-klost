
package views.html.tent

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

Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="modalDeleteTent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">

        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="headerTentDelete"></h4>
            </div>
            <div class="modal-body">
            """),_display_(/*13.14*/Messages("p.deleteTent")),format.raw/*13.38*/("""
            """),format.raw/*14.13*/("""</div>

            <div class="modal-footer">
                <div class="pull-left">
                    <form id="form" method="post" action="">
                        <button type="submit" class="btn btn-danger">"""),_display_(/*19.71*/Messages("btn.delete")),format.raw/*19.93*/("""</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">"""),_display_(/*20.93*/Messages("btn.back")),format.raw/*20.113*/("""</button>
                    </form>
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
                  DATE: Sun Mar 15 13:14:05 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/tent/modalDelete.scala.html
                  HASH: 214407de2f0d2b340fa081ab9bf4c670ed12fafd
                  MATRIX: 809->0|1396->560|1441->584|1483->598|1733->821|1776->843|1906->946|1948->966
                  LINES: 29->1|41->13|41->13|42->14|47->19|47->19|48->20|48->20
                  -- GENERATED --
              */
          