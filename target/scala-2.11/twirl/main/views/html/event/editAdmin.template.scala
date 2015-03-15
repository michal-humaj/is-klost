
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
object editAdmin extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,String,Boolean,Form[dto.EventTO],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(eventType: String, eventId: String, allDay: Boolean, eventForm: Form[dto.EventTO], returnDate: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.105*/("""

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

            """),_display_(/*20.14*/helper/*20.20*/.form(action = routes.Events.update(eventType, eventId), 'class -> "form-horizontal", 'role -> "form", 'id -> "form")/*20.137*/ {_display_(Seq[Any](format.raw/*20.139*/("""

                """),_display_(/*22.18*/views/*22.23*/.html.event.formEvent(eventType, eventId, allDay, eventForm)),format.raw/*22.83*/("""
                """),_display_(/*23.18*/views/*23.23*/.html.event.formEntries()),format.raw/*23.48*/("""

                """),format.raw/*25.17*/("""<div class="clearfix form-actions">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">"""),_display_(/*27.72*/Messages("btn.update")),format.raw/*27.94*/("""</button>
                            &nbsp;
                        <a class="btn" type="reset" href='"""),_display_(/*29.60*/routes/*29.66*/.App.calendar(returnDate)),format.raw/*29.91*/("""'>"""),_display_(/*29.94*/Messages("btn.back")),format.raw/*29.114*/("""</a>
                    </div>
                </div>
            """)))}),format.raw/*32.14*/("""

        """),format.raw/*34.9*/("""</div>
    </div>
""")))}/*36.2*/ {_display_(Seq[Any](format.raw/*36.4*/("""
    """),format.raw/*37.5*/("""<script src='"""),_display_(/*37.19*/routes/*37.25*/.Assets.at("js/eventEditCommon.js")),format.raw/*37.60*/("""'></script>
    <script src='"""),_display_(/*38.19*/routes/*38.25*/.Assets.at("js/eventEdit.js")),format.raw/*38.54*/("""'></script>
""")))}))}
  }

  def render(eventType:String,eventId:String,allDay:Boolean,eventForm:Form[dto.EventTO],returnDate:String): play.twirl.api.HtmlFormat.Appendable = apply(eventType,eventId,allDay,eventForm,returnDate)

  def f:((String,String,Boolean,Form[dto.EventTO],String) => play.twirl.api.HtmlFormat.Appendable) = (eventType,eventId,allDay,eventForm,returnDate) => apply(eventType,eventId,allDay,eventForm,returnDate)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 15 13:23:43 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/editAdmin.scala.html
                  HASH: 315bcf0d0133958e6cb608b34c8b897503d54233
                  MATRIX: 773->1|965->104|995->109|1007->114|1057->156|1068->159|1107->161|1127->164|1165->166|1197->172|1273->222|1316->245|1352->255|1471->347|1510->377|1550->379|1596->397|1674->448|1688->453|1722->466|1768->484|1820->505|1864->522|1879->528|2006->645|2047->647|2095->668|2109->673|2190->733|2236->752|2250->757|2296->782|2344->802|2524->955|2567->977|2700->1083|2715->1089|2761->1114|2791->1117|2833->1137|2935->1208|2974->1220|3013->1241|3052->1243|3085->1249|3126->1263|3141->1269|3197->1304|3255->1335|3270->1341|3320->1370
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|32->4|33->5|35->7|35->7|36->8|42->14|42->14|42->14|43->15|44->16|44->16|44->16|45->17|46->18|48->20|48->20|48->20|48->20|50->22|50->22|50->22|51->23|51->23|51->23|53->25|55->27|55->27|57->29|57->29|57->29|57->29|57->29|60->32|62->34|64->36|64->36|65->37|65->37|65->37|65->37|66->38|66->38|66->38
                  -- GENERATED --
              */
          