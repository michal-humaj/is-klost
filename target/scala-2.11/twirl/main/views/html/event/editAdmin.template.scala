
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
object editAdmin extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,String,Boolean,Form[dto.EventTO],String,Map[org.joda.time.LocalDate, List[dto.AvailTO]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(eventType: String, eventId: String, allDay: Boolean, eventForm: Form[dto.EventTO], returnDate: String, availMap: Map[org.joda.time.LocalDate, List[dto.AvailTO]]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import java.text.DecimalFormat

Seq[Any](format.raw/*1.164*/("""
"""),_display_(/*3.2*/views/*3.7*/.html.master.main(Messages("h.editEvent"))/*3.49*/(0)/*3.52*/ {_display_(Seq[Any](format.raw/*3.54*/("""
""")))}/*4.2*/ {_display_(Seq[Any](format.raw/*4.4*/("""
    """),format.raw/*5.5*/("""<div class="page-header">
        <h1>
        """),_display_(/*7.10*/Messages("h.editEvent")),format.raw/*7.33*/("""
        """),format.raw/*8.9*/("""</h1>
    </div>

    <div class="row">
        <div class="col-xs-12">

            """),_display_(/*14.14*/if(flash.containsKey("error"))/*14.44*/ {_display_(Seq[Any](format.raw/*14.46*/("""
                """),format.raw/*15.17*/("""<div class="alert alert-danger">
                """),_display_(/*16.18*/flash/*16.23*/.get("error")),format.raw/*16.36*/("""
                """),format.raw/*17.17*/("""</div>
            """)))}),format.raw/*18.14*/("""
            """),_display_(/*19.14*/if(availMap != null)/*19.34*/ {_display_(Seq[Any](format.raw/*19.36*/("""
                """),format.raw/*20.17*/("""<div class="alert alert-info">
                    <div>
                        <strong>
                            <i class="ace-icon fa fa-times"></i>
                            """),_display_(/*24.30*/Messages("f.warning")),format.raw/*24.51*/("""
                        """),format.raw/*25.25*/("""</strong>
                            """),_display_(/*26.30*/Messages("f.moreItemsReserved")),format.raw/*26.61*/("""
                    """),format.raw/*27.21*/("""</div>
                    <h5><b>"""),_display_(/*28.29*/Messages("h.itemsMissing")),format.raw/*28.55*/("""</b></h5>

                    <div>
                    """),_display_(/*31.22*/availMap/*31.30*/.keySet.map/*31.41*/ { a =>_display_(Seq[Any](format.raw/*31.48*/("""
                        """),format.raw/*32.25*/("""<a href='"""),_display_(/*32.35*/routes/*32.41*/.App.store(a.toString)),format.raw/*32.63*/("""' class="text-primary"><b>"""),_display_(/*32.90*/a/*32.91*/.toString("dd.MM. yyyy")),format.raw/*32.115*/("""</b></a>
                        <ul>
                        """),_display_(/*34.26*/availMap/*34.34*/.get(a).map/*34.45*/ { availTo =>_display_(Seq[Any](format.raw/*34.58*/("""
                            """),format.raw/*35.29*/("""<li>
                                """),_display_(/*36.34*/availTo/*36.41*/.name),format.raw/*36.46*/("""
                            """),format.raw/*37.29*/("""<strong class="text-danger">"""),_display_(/*37.58*/((new DecimalFormat("#0.##")).format(availTo.available))),format.raw/*37.114*/("""</strong>
                            </li>
                        """)))}),format.raw/*39.26*/("""
                        """),format.raw/*40.25*/("""</ul>
                    """)))}),format.raw/*41.22*/("""
                    """),format.raw/*42.21*/("""</div>
                    <div>
                        <strong>
                            <i class="ace-icon fa fa-floppy-o"></i>
                            """),_display_(/*46.30*/Messages("f.changesSaved")),format.raw/*46.56*/("""
                        """),format.raw/*47.25*/("""</strong>
                        <p>"""),_display_(/*48.29*/Messages("f.checkAvail")),format.raw/*48.53*/(""" """),format.raw/*48.54*/("""<a href='"""),_display_(/*48.64*/routes/*48.70*/.App.calendar(returnDate)),format.raw/*48.95*/("""'><b>"""),_display_(/*48.101*/Messages("f.goToCal")),format.raw/*48.122*/("""</b></a></p>
                    </div>
                </div>
            """)))}),format.raw/*51.14*/("""

            """),_display_(/*53.14*/helper/*53.20*/.form(action = routes.Events.update(eventType, eventId), 'class -> "form-horizontal", 'role -> "form", 'id -> "form")/*53.137*/ {_display_(Seq[Any](format.raw/*53.139*/("""

                """),_display_(/*55.18*/views/*55.23*/.html.event.formEvent(eventType, eventId, allDay, eventForm)),format.raw/*55.83*/("""
                """),_display_(/*56.18*/views/*56.23*/.html.event.formEntries()),format.raw/*56.48*/("""

                """),format.raw/*58.17*/("""<div class="clearfix form-actions">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">"""),_display_(/*60.72*/Messages("btn.update")),format.raw/*60.94*/("""</button>
                            &nbsp;
                        <a class="btn" type="reset" href='"""),_display_(/*62.60*/routes/*62.66*/.App.calendar(returnDate)),format.raw/*62.91*/("""'>"""),_display_(/*62.94*/Messages("btn.back")),format.raw/*62.114*/("""</a>
                    </div>
                </div>
            """)))}),format.raw/*65.14*/("""

        """),format.raw/*67.9*/("""</div>
    </div>
""")))}/*69.2*/ {_display_(Seq[Any](format.raw/*69.4*/("""
    """),format.raw/*70.5*/("""<script src='"""),_display_(/*70.19*/routes/*70.25*/.Assets.at("js/eventEditCommon.js")),format.raw/*70.60*/("""'></script>
    <script src='"""),_display_(/*71.19*/routes/*71.25*/.Assets.at("js/eventEdit.js")),format.raw/*71.54*/("""'></script>
""")))}))}
  }

  def render(eventType:String,eventId:String,allDay:Boolean,eventForm:Form[dto.EventTO],returnDate:String,availMap:Map[org.joda.time.LocalDate, List[dto.AvailTO]]): play.twirl.api.HtmlFormat.Appendable = apply(eventType,eventId,allDay,eventForm,returnDate,availMap)

  def f:((String,String,Boolean,Form[dto.EventTO],String,Map[org.joda.time.LocalDate, List[dto.AvailTO]]) => play.twirl.api.HtmlFormat.Appendable) = (eventType,eventId,allDay,eventForm,returnDate,availMap) => apply(eventType,eventId,allDay,eventForm,returnDate,availMap)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Apr 10 11:40:22 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/event/editAdmin.scala.html
                  HASH: 02952dd5b18542dcbc31ba5930cf43afb2e2057a
                  MATRIX: 821->1|1102->163|1130->199|1142->204|1192->246|1203->249|1242->251|1262->254|1300->256|1332->262|1408->312|1451->335|1487->345|1606->437|1645->467|1685->469|1731->487|1809->538|1823->543|1857->556|1903->574|1955->595|1997->610|2026->630|2066->632|2112->650|2327->838|2369->859|2423->885|2490->925|2542->956|2592->978|2655->1014|2702->1040|2790->1101|2807->1109|2827->1120|2872->1127|2926->1153|2963->1163|2978->1169|3021->1191|3075->1218|3085->1219|3131->1243|3223->1308|3240->1316|3260->1327|3311->1340|3369->1370|3435->1409|3451->1416|3477->1421|3535->1451|3591->1480|3669->1536|3771->1607|3825->1633|3884->1661|3934->1683|4128->1850|4175->1876|4229->1902|4295->1941|4340->1965|4369->1966|4406->1976|4421->1982|4467->2007|4501->2013|4544->2034|4654->2113|4698->2130|4713->2136|4840->2253|4881->2255|4929->2276|4943->2281|5024->2341|5070->2360|5084->2365|5130->2390|5178->2410|5358->2563|5401->2585|5534->2691|5549->2697|5595->2722|5625->2725|5667->2745|5769->2816|5808->2828|5847->2849|5886->2851|5919->2857|5960->2871|5975->2877|6031->2912|6089->2943|6104->2949|6154->2978
                  LINES: 26->1|29->1|30->3|30->3|30->3|30->3|30->3|31->4|31->4|32->5|34->7|34->7|35->8|41->14|41->14|41->14|42->15|43->16|43->16|43->16|44->17|45->18|46->19|46->19|46->19|47->20|51->24|51->24|52->25|53->26|53->26|54->27|55->28|55->28|58->31|58->31|58->31|58->31|59->32|59->32|59->32|59->32|59->32|59->32|59->32|61->34|61->34|61->34|61->34|62->35|63->36|63->36|63->36|64->37|64->37|64->37|66->39|67->40|68->41|69->42|73->46|73->46|74->47|75->48|75->48|75->48|75->48|75->48|75->48|75->48|75->48|78->51|80->53|80->53|80->53|80->53|82->55|82->55|82->55|83->56|83->56|83->56|85->58|87->60|87->60|89->62|89->62|89->62|89->62|89->62|92->65|94->67|96->69|96->69|97->70|97->70|97->70|97->70|98->71|98->71|98->71
                  -- GENERATED --
              */
          