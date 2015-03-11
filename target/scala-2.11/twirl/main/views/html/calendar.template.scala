
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
      _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),_display_(/*3.2*/views/*3.7*/.html.master.main(Messages("nav.cal"))/*3.45*/(0)/*3.48*/ {_display_(Seq[Any](format.raw/*3.50*/("""

    """),_display_(/*5.6*/views/*5.11*/.html.master.datepicker()),format.raw/*5.36*/("""
""")))}/*6.2*/ {_display_(Seq[Any](format.raw/*6.4*/("""
    """),_display_(/*7.6*/views/*7.11*/.html.event.popoverNew()),format.raw/*7.35*/("""

    """),_display_(/*9.6*/views/*9.11*/.html.event.popoverClick()),format.raw/*9.37*/("""

    """),_display_(/*11.6*/views/*11.11*/.html.event.modalDelete()),format.raw/*11.36*/("""

    """),format.raw/*13.5*/("""<div class="row">
        <div class="col-sm-12">
            <div id="fullcalendar" data-date=""""),_display_(/*15.48*/date),format.raw/*15.52*/(""""></div>
        </div>
    </div>
""")))}/*18.2*/ {_display_(Seq[Any](format.raw/*18.4*/("""

    """),format.raw/*20.5*/("""<script src='"""),_display_(/*20.19*/routes/*20.25*/.Assets.at("js/calendarCommon.js")),format.raw/*20.59*/("""'></script>
    <script src='"""),_display_(/*21.19*/routes/*21.25*/.Assets.at("js/calendarAdmin.js")),format.raw/*21.58*/("""'></script>
""")))}))}
  }

  def render(date:String): play.twirl.api.HtmlFormat.Appendable = apply(date)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (date) => apply(date)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Mar 11 23:40:19 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/calendar.scala.html
                  HASH: 1aa05af2425d565b4264389aa9c15144dbb31dbb
                  MATRIX: 726->1|828->15|858->20|870->25|916->63|927->66|966->68|1000->77|1013->82|1058->107|1078->110|1116->112|1148->119|1161->124|1205->148|1239->157|1252->162|1298->188|1333->197|1347->202|1393->227|1428->235|1554->334|1579->338|1636->377|1675->379|1710->387|1751->401|1766->407|1821->441|1879->472|1894->478|1948->511
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|33->5|33->5|33->5|34->6|34->6|35->7|35->7|35->7|37->9|37->9|37->9|39->11|39->11|39->11|41->13|43->15|43->15|46->18|46->18|48->20|48->20|48->20|48->20|49->21|49->21|49->21
                  -- GENERATED --
              */
          