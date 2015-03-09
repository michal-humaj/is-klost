
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
object popoverClick extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div id="popoverClick" class="hide">
    <form class="form-horizontal" role="form">

        <div class="form-group" >
            <div class="col-sm-6">
                <a class="btn btn-white btn-inverse btnPopover" type="submit"><i class="ace-icon fa fa-file bigger-110"></i>
                    """),_display_(/*7.22*/Messages("btn.priceOffer")),format.raw/*7.48*/("""
                """),format.raw/*8.17*/("""</a>
            </div>
            <div class="col-sm-6">
                <a class="btn btn-white btn-inverse btnPopover" type="submit"><i class="ace-icon fa fa-calendar-o bigger-110"></i>
                    """),_display_(/*12.22*/Messages("btn.toAction")),format.raw/*12.46*/("""
                """),format.raw/*13.17*/("""</a>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-6">
                <a class="btn btn-sm btn-danger btnPopover" data-bind="click: modalDelete">
                    <i class="ace-icon fa fa-trash-o bigger-110"></i>
                    """),_display_(/*21.22*/Messages("btn.delete")),format.raw/*21.44*/("""
                """),format.raw/*22.17*/("""</a>
            </div>
            <div class="col-sm-6">
                <a class="btn btn-sm btn-info btnPopover" href data-bind="attr: """),format.raw/*25.81*/("""{"""),format.raw/*25.82*/(""" """),format.raw/*25.83*/("""href: '/event/' + event().eventType() + '/' + event().id() """),format.raw/*25.142*/("""}"""),format.raw/*25.143*/("""">
                    <i class="ace-icon fa fa-pencil bigger-110"></i>
                    """),_display_(/*27.22*/Messages("btn.edit")),format.raw/*27.42*/("""
                """),format.raw/*28.17*/("""</a>
            </div>
        </div>

    </form>
</div>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Mar 09 21:53:21 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/popoverClick.scala.html
                  HASH: 0498c5ce718ba21c9ffb3c22efbd8c3c9766d3a9
                  MATRIX: 811->0|1143->306|1189->332|1234->350|1476->565|1521->589|1567->607|1893->906|1936->928|1982->946|2152->1088|2181->1089|2210->1090|2298->1149|2328->1150|2450->1245|2491->1265|2537->1283
                  LINES: 29->1|35->7|35->7|36->8|40->12|40->12|41->13|49->21|49->21|50->22|53->25|53->25|53->25|53->25|53->25|55->27|55->27|56->28
                  -- GENERATED --
              */
          