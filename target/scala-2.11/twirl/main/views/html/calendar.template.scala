
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

    """),format.raw/*10.5*/("""<div class="row">
        <div class="col-xs-12">
            <blockquote class="pull-right" style="font-size: 14px;">
                <p id="pMouseOverEvent"></p>
            </blockquote>
        </div>
    </div>
""")))}/*17.2*/ {_display_(Seq[Any](format.raw/*17.4*/("""
    """),_display_(/*18.6*/views/*18.11*/.html.event.popoverNew()),format.raw/*18.35*/("""

    """),_display_(/*20.6*/views/*20.11*/.html.event.popoverClick()),format.raw/*20.37*/("""

    """),_display_(/*22.6*/views/*22.11*/.html.event.popoverStrmn()),format.raw/*22.37*/("""

    """),_display_(/*24.6*/views/*24.11*/.html.event.modalDelete()),format.raw/*24.36*/("""

    """),format.raw/*26.5*/("""<div id="calIds"
        data-calIdsAction='"""),_display_(/*27.29*/ConfigFactory/*27.42*/.load().getString("calIds.action")),format.raw/*27.76*/("""'
        data-calIdsReservation='"""),_display_(/*28.34*/ConfigFactory/*28.47*/.load().getString("calIds.reservation")),format.raw/*28.86*/("""'
        data-calIdsInstallation='"""),_display_(/*29.35*/ConfigFactory/*29.48*/.load().getString("calIds.installation")),format.raw/*29.88*/("""'
        data-calIdsSelftransport='"""),_display_(/*30.36*/ConfigFactory/*30.49*/.load().getString("calIds.selftransport")),format.raw/*30.90*/("""'>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <div id="fullcalendar" data-date=""""),_display_(/*35.48*/date),format.raw/*35.52*/(""""></div>
        </div>
    </div>
""")))}/*38.2*/ {_display_(Seq[Any](format.raw/*38.4*/("""
    """),format.raw/*39.5*/("""<script src='"""),_display_(/*39.19*/routes/*39.25*/.Assets.at("js/calendarCommon.js")),format.raw/*39.59*/("""'></script>
    """),_display_(/*40.6*/currentAuth()/*40.19*/ { auth =>_display_(Seq[Any](format.raw/*40.29*/("""
        """),_display_(/*41.10*/if(LoggedAdmin.isAdminId(auth.getId()))/*41.49*/ {_display_(Seq[Any](format.raw/*41.51*/("""
            """),format.raw/*42.13*/("""<script src='"""),_display_(/*42.27*/routes/*42.33*/.Assets.at("js/calendarAdmin.js")),format.raw/*42.66*/("""'></script>
        """)))}/*43.11*/else/*43.16*/{_display_(Seq[Any](format.raw/*43.17*/("""
            """),format.raw/*44.13*/("""<script src='"""),_display_(/*44.27*/routes/*44.33*/.Assets.at("js/calendarStrmn.js")),format.raw/*44.66*/("""'></script>
        """)))}),format.raw/*45.10*/("""
    """)))}),format.raw/*46.6*/("""
""")))}))}
  }

  def render(date:String): play.twirl.api.HtmlFormat.Appendable = apply(date)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (date) => apply(date)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 14 14:48:10 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/calendar.scala.html
                  HASH: ad519cfd75705e63cfab211df82084639d086432
                  MATRIX: 726->1|912->15|940->104|967->106|979->111|1025->149|1036->152|1075->154|1107->161|1120->166|1165->191|1198->197|1433->414|1472->416|1504->422|1518->427|1563->451|1596->458|1610->463|1657->489|1690->496|1704->501|1751->527|1784->534|1798->539|1844->564|1877->570|1949->615|1971->628|2026->662|2088->697|2110->710|2170->749|2233->785|2255->798|2316->838|2380->875|2402->888|2464->929|2607->1045|2632->1049|2686->1085|2725->1087|2757->1092|2798->1106|2813->1112|2868->1146|2911->1163|2933->1176|2981->1186|3018->1196|3066->1235|3106->1237|3147->1250|3188->1264|3203->1270|3257->1303|3297->1325|3310->1330|3349->1331|3390->1344|3431->1358|3446->1364|3500->1397|3552->1418|3588->1424
                  LINES: 26->1|30->1|32->5|33->6|33->6|33->6|33->6|33->6|35->8|35->8|35->8|37->10|44->17|44->17|45->18|45->18|45->18|47->20|47->20|47->20|49->22|49->22|49->22|51->24|51->24|51->24|53->26|54->27|54->27|54->27|55->28|55->28|55->28|56->29|56->29|56->29|57->30|57->30|57->30|62->35|62->35|65->38|65->38|66->39|66->39|66->39|66->39|67->40|67->40|67->40|68->41|68->41|68->41|69->42|69->42|69->42|69->42|70->43|70->43|70->43|71->44|71->44|71->44|71->44|72->45|73->46
                  -- GENERATED --
              */
          