
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

        <div class="form-group" data-bind="attr: """),format.raw/*4.50*/("""{"""),format.raw/*4.51*/(""" """),format.raw/*4.52*/("""class: event().isDownloadDocBtnVisible() ? 'form-group' : 'form-group hide' """),format.raw/*4.128*/("""}"""),format.raw/*4.129*/("""">
            <div class="col-sm-6" data-bind="attr: """),format.raw/*5.52*/("""{"""),format.raw/*5.53*/(""" """),format.raw/*5.54*/("""class: event().isDownloadDocBtnVisible() ? 'col-sm-6' : 'col-sm-6 hide' """),format.raw/*5.126*/("""}"""),format.raw/*5.127*/("""">
                <a class="btn btn-white btn-inverse btnPopover" onclick="removePopovers ( )"
                href data-bind="attr: """),format.raw/*7.39*/("""{"""),format.raw/*7.40*/(""" """),format.raw/*7.41*/("""href: '/contract/' + event().eventType() + '/' + event().id() """),format.raw/*7.103*/("""}"""),format.raw/*7.104*/("""">
                    <i class="ace-icon fa fa-file bigger-110"></i>
                        <!--ko text: event().downloadDocText--><!--/ko-->
                </a>
            </div>

            <div class="col-sm-6">
                <a class="btn btn-white btn-inverse btnPopover" href data-bind="attr: """),format.raw/*14.87*/("""{"""),format.raw/*14.88*/(""" """),format.raw/*14.89*/("""href: '/loadingList/' + event().eventType() + '/' + event().id() """),format.raw/*14.154*/("""}"""),format.raw/*14.155*/("""">
                    <i class="ace-icon fa fa-truck bigger-110"></i>
                    """),_display_(/*16.22*/Messages("btn.loadingList")),format.raw/*16.49*/("""
                """),format.raw/*17.17*/("""</a>
            </div>


        </div>

        <div class="form-group">
            <div class="col-sm-6">
                <a class="btn btn-sm btn-danger btnPopover" data-bind="click: modalDelete">
                    <i class="ace-icon fa fa-trash-o bigger-110"></i>
                    """),_display_(/*27.22*/Messages("btn.delete")),format.raw/*27.44*/("""
                """),format.raw/*28.17*/("""</a>
            </div>

            <div class="col-sm-6" data-bind="attr: """),format.raw/*31.52*/("""{"""),format.raw/*31.53*/(""" """),format.raw/*31.54*/("""class: event().isChangeCalBtnVisible() ? 'col-sm-6' : 'col-sm-6 hide' """),format.raw/*31.124*/("""}"""),format.raw/*31.125*/("""" >
                <a class="btn btn-white btn-inverse btnPopover" type="submit" data-bind="click: changeCal">
                    <i class="ace-icon fa fa-calendar-o bigger-110"></i>
                        <!--ko text: event().changeCalText--><!--/ko-->
                </a>
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
                  DATE: Fri Apr 10 11:59:44 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/event/popoverClick.scala.html
                  HASH: fe7d1d7d5ba030afbe62da8ad7af7203de5bf8b3
                  MATRIX: 811->0|972->134|1000->135|1028->136|1132->212|1161->213|1242->267|1270->268|1298->269|1398->341|1427->342|1588->476|1616->477|1644->478|1734->540|1763->541|2097->847|2126->848|2155->849|2249->914|2279->915|2398->1007|2446->1034|2491->1051|2811->1344|2854->1366|2899->1383|3003->1459|3032->1460|3061->1461|3160->1531|3190->1532
                  LINES: 29->1|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|33->5|33->5|35->7|35->7|35->7|35->7|35->7|42->14|42->14|42->14|42->14|42->14|44->16|44->16|45->17|55->27|55->27|56->28|59->31|59->31|59->31|59->31|59->31
                  -- GENERATED --
              */
          