
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

Seq[Any](format.raw/*1.16*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/views/*5.7*/.html.master.main(Messages("nav.cal"))/*5.45*/(0)/*5.48*/ {_display_(Seq[Any](format.raw/*5.50*/("""

    """),_display_(/*7.6*/views/*7.11*/.html.master.datepicker()),format.raw/*7.36*/("""
""")))}/*8.2*/ {_display_(Seq[Any](format.raw/*8.4*/("""
    """),_display_(/*9.6*/views/*9.11*/.html.event.popoverNew()),format.raw/*9.35*/("""

    """),_display_(/*11.6*/views/*11.11*/.html.event.popoverClick()),format.raw/*11.37*/("""

    """),_display_(/*13.6*/views/*13.11*/.html.event.popoverStrmn()),format.raw/*13.37*/("""

    """),_display_(/*15.6*/views/*15.11*/.html.event.modalDelete()),format.raw/*15.36*/("""

    """),format.raw/*17.5*/("""<div class="row">
        <div class="col-sm-12">
            <div id="fullcalendar" data-date=""""),_display_(/*19.48*/date),format.raw/*19.52*/(""""></div>
        </div>
    </div>
""")))}/*22.2*/ {_display_(Seq[Any](format.raw/*22.4*/("""
    """),format.raw/*23.5*/("""<script src='"""),_display_(/*23.19*/routes/*23.25*/.Assets.at("js/calendarCommon.js")),format.raw/*23.59*/("""'></script>
    """),_display_(/*24.6*/currentAuth()/*24.19*/ { auth =>_display_(Seq[Any](format.raw/*24.29*/("""
        """),_display_(/*25.10*/if(LoggedAdmin.isAdminId(auth.getId()))/*25.49*/ {_display_(Seq[Any](format.raw/*25.51*/("""
            """),format.raw/*26.13*/("""<script src='"""),_display_(/*26.27*/routes/*26.33*/.Assets.at("js/calendarAdmin.js")),format.raw/*26.66*/("""'></script>
        """)))}/*27.11*/else/*27.16*/{_display_(Seq[Any](format.raw/*27.17*/("""
            """),format.raw/*28.13*/("""<script src='"""),_display_(/*28.27*/routes/*28.33*/.Assets.at("js/calendarStrmn.js")),format.raw/*28.66*/("""'></script>
        """)))}),format.raw/*29.10*/("""
    """)))}),format.raw/*30.6*/("""
""")))}))}
  }

  def render(date:String): play.twirl.api.HtmlFormat.Appendable = apply(date)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (date) => apply(date)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 15 13:14:04 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/calendar.scala.html
                  HASH: 6da25c104fcfd175a9e530eab71668ab50738d2e
                  MATRIX: 726->1|871->15|901->65|929->68|941->73|987->111|998->114|1037->116|1071->125|1084->130|1129->155|1149->158|1187->160|1219->167|1232->172|1276->196|1311->205|1325->210|1372->236|1407->245|1421->250|1468->276|1503->285|1517->290|1563->315|1598->323|1724->422|1749->426|1806->465|1845->467|1878->473|1919->487|1934->493|1989->527|2033->545|2055->558|2103->568|2141->579|2189->618|2229->620|2271->634|2312->648|2327->654|2381->687|2422->710|2435->715|2474->716|2516->730|2557->744|2572->750|2626->783|2679->805|2716->812
                  LINES: 26->1|29->1|31->4|32->5|32->5|32->5|32->5|32->5|34->7|34->7|34->7|35->8|35->8|36->9|36->9|36->9|38->11|38->11|38->11|40->13|40->13|40->13|42->15|42->15|42->15|44->17|46->19|46->19|49->22|49->22|50->23|50->23|50->23|50->23|51->24|51->24|51->24|52->25|52->25|52->25|53->26|53->26|53->26|53->26|54->27|54->27|54->27|55->28|55->28|55->28|55->28|56->29|57->30
                  -- GENERATED --
              */
          