
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
                  DATE: Tue Apr 14 14:48:11 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/event/editAdmin.scala.html
                  HASH: da1bb6f123e09e70022503abdcfd1d829072b5c2
                  MATRIX: 821->1|1102->163|1129->197|1141->202|1191->244|1202->247|1241->249|1260->251|1298->253|1329->258|1403->306|1446->329|1481->338|1594->424|1633->454|1673->456|1718->473|1795->523|1809->528|1843->541|1888->558|1939->578|1980->592|2009->612|2049->614|2094->631|2305->815|2347->836|2400->861|2466->900|2518->931|2567->952|2629->987|2676->1013|2761->1071|2778->1079|2798->1090|2843->1097|2896->1122|2933->1132|2948->1138|2991->1160|3045->1187|3055->1188|3101->1212|3191->1275|3208->1283|3228->1294|3279->1307|3336->1336|3401->1374|3417->1381|3443->1386|3500->1415|3556->1444|3634->1500|3734->1569|3787->1594|3845->1621|3894->1642|4084->1805|4131->1831|4184->1856|4249->1894|4294->1918|4323->1919|4360->1929|4375->1935|4421->1960|4455->1966|4498->1987|4605->2063|4647->2078|4662->2084|4789->2201|4830->2203|4876->2222|4890->2227|4971->2287|5016->2305|5030->2310|5076->2335|5122->2353|5300->2504|5343->2526|5474->2630|5489->2636|5535->2661|5565->2664|5607->2684|5706->2752|5743->2762|5780->2781|5819->2783|5851->2788|5892->2802|5907->2808|5963->2843|6020->2873|6035->2879|6085->2908
                  LINES: 26->1|29->1|30->3|30->3|30->3|30->3|30->3|31->4|31->4|32->5|34->7|34->7|35->8|41->14|41->14|41->14|42->15|43->16|43->16|43->16|44->17|45->18|46->19|46->19|46->19|47->20|51->24|51->24|52->25|53->26|53->26|54->27|55->28|55->28|58->31|58->31|58->31|58->31|59->32|59->32|59->32|59->32|59->32|59->32|59->32|61->34|61->34|61->34|61->34|62->35|63->36|63->36|63->36|64->37|64->37|64->37|66->39|67->40|68->41|69->42|73->46|73->46|74->47|75->48|75->48|75->48|75->48|75->48|75->48|75->48|75->48|78->51|80->53|80->53|80->53|80->53|82->55|82->55|82->55|83->56|83->56|83->56|85->58|87->60|87->60|89->62|89->62|89->62|89->62|89->62|92->65|94->67|96->69|96->69|97->70|97->70|97->70|97->70|98->71|98->71|98->71
                  -- GENERATED --
              */
          