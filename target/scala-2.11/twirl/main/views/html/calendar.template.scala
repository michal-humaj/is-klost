
package views.html

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
object calendar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(date: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import com.feth.play.module.pa.views.html._
import com.typesafe.config.ConfigFactory

Seq[Any](format.raw/*1.16*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/views/*6.7*/.html.master.main(Messages("nav.cal"))/*6.45*/(0)/*6.48*/ {_display_(Seq[Any](format.raw/*6.50*/("""

    """),_display_(/*8.6*/views/*8.11*/.html.master.datepicker()),format.raw/*8.36*/("""
""")))}/*9.2*/ {_display_(Seq[Any](format.raw/*9.4*/("""
    """),_display_(/*10.6*/views/*10.11*/.html.event.popoverNew()),format.raw/*10.35*/("""

    """),_display_(/*12.6*/views/*12.11*/.html.event.popoverClick()),format.raw/*12.37*/("""

    """),_display_(/*14.6*/views/*14.11*/.html.event.popoverStrmn()),format.raw/*14.37*/("""

    """),_display_(/*16.6*/views/*16.11*/.html.event.modalDelete()),format.raw/*16.36*/("""

    """),format.raw/*18.5*/("""<div id="calIds"
        data-calIdsAction='"""),_display_(/*19.29*/ConfigFactory/*19.42*/.load().getString("calIds.action")),format.raw/*19.76*/("""'
        data-calIdsReservation='"""),_display_(/*20.34*/ConfigFactory/*20.47*/.load().getString("calIds.reservation")),format.raw/*20.86*/("""'
        data-calIdsInstallation='"""),_display_(/*21.35*/ConfigFactory/*21.48*/.load().getString("calIds.installation")),format.raw/*21.88*/("""'
        data-calIdsSelftransport='"""),_display_(/*22.36*/ConfigFactory/*22.49*/.load().getString("calIds.selftransport")),format.raw/*22.90*/("""'>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <div id="fullcalendar" data-date=""""),_display_(/*27.48*/date),format.raw/*27.52*/(""""></div>
        </div>
    </div>
""")))}/*30.2*/ {_display_(Seq[Any](format.raw/*30.4*/("""
    """),format.raw/*31.5*/("""<script src='"""),_display_(/*31.19*/routes/*31.25*/.Assets.at("js/calendarCommon.js")),format.raw/*31.59*/("""'></script>
    """),_display_(/*32.6*/currentAuth()/*32.19*/ { auth =>_display_(Seq[Any](format.raw/*32.29*/("""
        """),_display_(/*33.10*/if(LoggedAdmin.isAdminId(auth.getId()))/*33.49*/ {_display_(Seq[Any](format.raw/*33.51*/("""
            """),format.raw/*34.13*/("""<script src='"""),_display_(/*34.27*/routes/*34.33*/.Assets.at("js/calendarAdmin.js")),format.raw/*34.66*/("""'></script>
        """)))}/*35.11*/else/*35.16*/{_display_(Seq[Any](format.raw/*35.17*/("""
            """),format.raw/*36.13*/("""<script src='"""),_display_(/*36.27*/routes/*36.33*/.Assets.at("js/calendarStrmn.js")),format.raw/*36.66*/("""'></script>
        """)))}),format.raw/*37.10*/("""
    """)))}),format.raw/*38.6*/("""
""")))}))}
  }

  def render(date:String): play.twirl.api.HtmlFormat.Appendable = apply(date)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (date) => apply(date)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Apr 10 11:59:43 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/calendar.scala.html
                  HASH: cf631815e0422770ec8ee4de4747cae447e498dc
                  MATRIX: 726->1|912->15|940->104|967->106|979->111|1025->149|1036->152|1075->154|1107->161|1120->166|1165->191|1184->193|1222->195|1254->201|1268->206|1313->230|1346->237|1360->242|1407->268|1440->275|1454->280|1501->306|1534->313|1548->318|1594->343|1627->349|1699->394|1721->407|1776->441|1838->476|1860->489|1920->528|1983->564|2005->577|2066->617|2130->654|2152->667|2214->708|2357->824|2382->828|2436->864|2475->866|2507->871|2548->885|2563->891|2618->925|2661->942|2683->955|2731->965|2768->975|2816->1014|2856->1016|2897->1029|2938->1043|2953->1049|3007->1082|3047->1104|3060->1109|3099->1110|3140->1123|3181->1137|3196->1143|3250->1176|3302->1197|3338->1203
                  LINES: 26->1|30->1|32->5|33->6|33->6|33->6|33->6|33->6|35->8|35->8|35->8|36->9|36->9|37->10|37->10|37->10|39->12|39->12|39->12|41->14|41->14|41->14|43->16|43->16|43->16|45->18|46->19|46->19|46->19|47->20|47->20|47->20|48->21|48->21|48->21|49->22|49->22|49->22|54->27|54->27|57->30|57->30|58->31|58->31|58->31|58->31|59->32|59->32|59->32|60->33|60->33|60->33|61->34|61->34|61->34|61->34|62->35|62->35|62->35|63->36|63->36|63->36|63->36|64->37|65->38
                  -- GENERATED --
              */
          