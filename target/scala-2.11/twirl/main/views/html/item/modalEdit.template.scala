
package views.html.item

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
object modalEdit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="modalEditItem" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog ">

        <form class="form-horizontal" role="form">

            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">"""),_display_(/*12.46*/Messages("h.editItem")),format.raw/*12.68*/("""</h4>
                </div>

                <div class="modal-body">

                    """),_display_(/*17.22*/views/*17.27*/.html.item.form("selectCategoryEditItem")),format.raw/*17.68*/("""

                """),format.raw/*19.17*/("""</div>

                <div class="modal-footer">
                    <div class="pull-left">
                        <button type="button" class="btn btn-primary" data-bind="click: update">"""),_display_(/*23.98*/Messages("btn.update")),format.raw/*23.120*/("""</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">"""),_display_(/*24.93*/Messages("btn.back")),format.raw/*24.113*/("""</button>
                    </div>
                </div>

            </div>

        </form>

    </div>
</div>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Apr 08 17:32:51 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/item/modalEdit.scala.html
                  HASH: 2ca3d4cc8fdc8fe15e5d798b17118f2f96593f04
                  MATRIX: 807->0|1372->538|1415->560|1540->658|1554->663|1616->704|1664->724|1887->920|1931->942|2061->1045|2103->1065
                  LINES: 29->1|40->12|40->12|45->17|45->17|45->17|47->19|51->23|51->23|52->24|52->24
                  -- GENERATED --
              */
          