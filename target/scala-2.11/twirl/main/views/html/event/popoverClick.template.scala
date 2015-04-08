
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

            <div class="col-sm-6" data-bind="attr: """),format.raw/*20.52*/("""{"""),format.raw/*20.53*/(""" """),format.raw/*20.54*/("""class: event().isChangeCalBtnVisible() ? 'col-sm-6' : 'col-sm-6 hide' """),format.raw/*20.124*/("""}"""),format.raw/*20.125*/("""" >
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
                    """),_display_(/*32.22*/Messages("btn.delete")),format.raw/*32.44*/("""
                """),format.raw/*33.17*/("""</a>
            </div>
            <div class="col-sm-6">
                <a class="btn btn-sm btn-info btnPopover" href data-bind="attr: """),format.raw/*36.81*/("""{"""),format.raw/*36.82*/(""" """),format.raw/*36.83*/("""href: '/event/' + event().eventType() + '/' + event().id() """),format.raw/*36.142*/("""}"""),format.raw/*36.143*/("""">
                    <i class="ace-icon fa fa-pencil bigger-110"></i>
                    """),_display_(/*38.22*/Messages("btn.edit")),format.raw/*38.42*/("""
                """),format.raw/*39.17*/("""</a>
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
                  DATE: Wed Apr 08 17:32:51 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/event/popoverClick.scala.html
                  HASH: 643c3c242c1cd90f338249893593433ef6e4c567
                  MATRIX: 811->0|975->137|1003->138|1031->139|1135->215|1164->216|1246->271|1274->272|1302->273|1402->345|1431->346|1594->482|1622->483|1650->484|1740->546|1769->547|2110->860|2139->861|2168->862|2262->927|2292->928|2413->1022|2461->1049|2507->1067|2614->1146|2643->1147|2672->1148|2771->1218|2801->1219|3404->1795|3447->1817|3493->1835|3663->1977|3692->1978|3721->1979|3809->2038|3839->2039|3961->2134|4002->2154|4048->2172
                  LINES: 29->1|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5|33->5|33->5|35->7|35->7|35->7|35->7|35->7|42->14|42->14|42->14|42->14|42->14|44->16|44->16|45->17|48->20|48->20|48->20|48->20|48->20|60->32|60->32|61->33|64->36|64->36|64->36|64->36|64->36|66->38|66->38|67->39
                  -- GENERATED --
              */
          