
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
object modalNew extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="modalNewItem" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog ">

        <form class="form-horizontal" role="form">

            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">"""),_display_(/*12.46*/Messages("h.newItem")),format.raw/*12.67*/("""</h4>
                </div>

                <div class="modal-body">

                    """),_display_(/*17.22*/views/*17.27*/.html.item.form("selectCategoryNewItem")),format.raw/*17.67*/("""

                """),format.raw/*19.17*/("""</div>

                <div class="modal-footer">
                    <div class="pull-left">
                        <button type="button" class="btn btn-primary" data-bind="click: add">"""),_display_(/*23.95*/Messages("btn.addItem")),format.raw/*23.118*/("""</button>
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
                  DATE: Tue Apr 14 14:48:11 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/item/modalNew.scala.html
                  HASH: f265a7b4a3cd177bcc3137cc52d138b6c382f623
                  MATRIX: 806->0|1370->537|1412->558|1537->656|1551->661|1612->701|1660->721|1880->914|1925->937|2055->1040|2097->1060
                  LINES: 29->1|40->12|40->12|45->17|45->17|45->17|47->19|51->23|51->23|52->24|52->24
                  -- GENERATED --
              */
          