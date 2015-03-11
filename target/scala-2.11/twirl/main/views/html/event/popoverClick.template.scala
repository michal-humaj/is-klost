
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
            <div class="col-sm-6" data-bind="attr: """),format.raw/*10.52*/("""{"""),format.raw/*10.53*/(""" """),format.raw/*10.54*/("""class: event().isChangeCalBtnVisible() ? 'col-sm-6' : 'col-sm-6 hide' """),format.raw/*10.124*/("""}"""),format.raw/*10.125*/("""" >
                <a class="btn btn-white btn-inverse btnPopover" type="submit" data-bind="click: changeCal">
                    <i class="ace-icon fa fa-calendar-o bigger-110"></i>
                    <!--ko text: event().changeCalText--><!--/ko-->
                </a>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-6">
                <a class="btn btn-sm btn-danger btnPopover" data-bind="click: modalDelete">
                    <i class="ace-icon fa fa-trash-o bigger-110"></i>
                    """),_display_(/*22.22*/Messages("btn.delete")),format.raw/*22.44*/("""
                """),format.raw/*23.17*/("""</a>
            </div>
            <div class="col-sm-6">
                <a class="btn btn-sm btn-info btnPopover" href data-bind="attr: """),format.raw/*26.81*/("""{"""),format.raw/*26.82*/(""" """),format.raw/*26.83*/("""href: '/event/' + event().eventType() + '/' + event().id() """),format.raw/*26.142*/("""}"""),format.raw/*26.143*/("""">
                    <i class="ace-icon fa fa-pencil bigger-110"></i>
                    """),_display_(/*28.22*/Messages("btn.edit")),format.raw/*28.42*/("""
                """),format.raw/*29.17*/("""</a>
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
                  DATE: Wed Mar 11 23:40:20 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/popoverClick.scala.html
                  HASH: 01765a419fca6d3b0ec336997d9b79d5f5b091c7
                  MATRIX: 811->0|1143->306|1189->332|1234->350|1339->427|1368->428|1397->429|1496->499|1526->500|2125->1072|2168->1094|2214->1112|2384->1254|2413->1255|2442->1256|2530->1315|2560->1316|2682->1411|2723->1431|2769->1449
                  LINES: 29->1|35->7|35->7|36->8|38->10|38->10|38->10|38->10|38->10|50->22|50->22|51->23|54->26|54->26|54->26|54->26|54->26|56->28|56->28|57->29
                  -- GENERATED --
              */
          