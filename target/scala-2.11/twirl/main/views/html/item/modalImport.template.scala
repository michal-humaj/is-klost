
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
object modalImport extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<div class="modal fade" id="modalImportItem" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">

        <form class="form-horizontal" role="form">

            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" data-bind="text: item().name()"></h4>
                </div>
                <div class="modal-body">
                    <div class="form-group" data-bind="attr: """),format.raw/*15.62*/("""{"""),format.raw/*15.63*/(""" """),format.raw/*15.64*/("""class: importAmount.isValid() ? 'form-group' : 'form-group has-info' """),format.raw/*15.133*/("""}"""),format.raw/*15.134*/("""">
                        <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*16.81*/Messages("lbl.import")),format.raw/*16.103*/("""</label>
                        <div class="col-sm-3 controls">
                            <div class="input-group">
                                <input id="inputImportAmount" class="form-control" placeholder="4" data-bind="value: importAmount().value">
                                <span class="input-group-addon"
                                    data-bind="text: item().category() === 'CARPET' ? Messages('lbl.m') : Messages('lbl.pcs') ">
                                </span>
                            </div>
                        </div>
                        <div class="help-block col-sm-reset inline" data-bind="validationMessage: importAmount().value"></div>
                    </div>
                </div>

                <div class="modal-footer">
                    <div class="pull-left">
                        <button type="button" class="btn btn-primary" data-bind="click: imprt">"""),_display_(/*31.97*/Messages("btn.import")),format.raw/*31.119*/("""</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">"""),_display_(/*32.93*/Messages("btn.back")),format.raw/*32.113*/("""</button>
                    </div>
                </div>

            </div>

        </form>

    </div>
</div>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 15 19:57:55 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/item/modalImport.scala.html
                  HASH: d82b2378558032c15d9c3562291282909915e2c3
                  MATRIX: 809->0|1541->704|1570->705|1599->706|1697->775|1727->776|1838->860|1882->882|2843->1816|2887->1838|3017->1941|3059->1961
                  LINES: 29->1|43->15|43->15|43->15|43->15|43->15|44->16|44->16|59->31|59->31|60->32|60->32
                  -- GENERATED --
              */
          