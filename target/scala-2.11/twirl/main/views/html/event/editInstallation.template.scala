
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
object editInstallation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,Boolean,Form[dto.EventTO],dto.EventsContainer,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(eventId: String, allDay: Boolean, eventForm: Form[dto.EventTO], upcomingActions: dto.EventsContainer, returnDate: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.124*/("""

"""),_display_(/*3.2*/views/*3.7*/.html.master.main(Messages("h.editInstallation"))/*3.56*/(0)/*3.59*/ {_display_(Seq[Any](format.raw/*3.61*/("""
""")))}/*4.2*/ {_display_(Seq[Any](format.raw/*4.4*/("""
    """),format.raw/*5.5*/("""<div class="page-header">
        <h1>
        """),_display_(/*7.10*/Messages("h.editInstallation")),format.raw/*7.40*/("""
        """),format.raw/*8.9*/("""</h1>
    </div>

    <div class="row">
        <div class="col-xs-12">

            """),_display_(/*14.14*/if(flash.containsKey("error"))/*14.44*/ {_display_(Seq[Any](format.raw/*14.46*/("""
                """),format.raw/*15.17*/("""<div class="alert alert-danger">
                """),_display_(/*16.18*/flash/*16.23*/.get("error")),format.raw/*16.36*/("""
                """),format.raw/*17.17*/("""</div>
            """)))}),format.raw/*18.14*/("""

            """),_display_(/*20.14*/helper/*20.20*/.form(action = routes.Events.updateInstl(eventId), 'class -> "form-horizontal", 'role -> "form", 'id -> "form")/*20.131*/ {_display_(Seq[Any](format.raw/*20.133*/("""

                """),_display_(/*22.18*/views/*22.23*/.html.event.formEvent("INSTALLATION", eventId, allDay, eventForm)),format.raw/*22.88*/("""

                """),format.raw/*24.17*/("""<div class="form-group">
                    <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*25.77*/Messages("lbl.assignedAction")),format.raw/*25.107*/("""</label>

                    <div class="col-sm-7">
                        <select name="actionId" class="form-control" value='"""),_display_(/*28.78*/eventForm/*28.87*/.field("actionId").value),format.raw/*28.111*/("""'>
                        """),_display_(/*29.26*/for(action <- upcomingActions.actions) yield /*29.64*/ {_display_(Seq[Any](format.raw/*29.66*/("""
                            """),format.raw/*30.29*/("""<option """),_display_(/*30.38*/if(action.id.equals(eventForm.field("actionId").value))/*30.93*/{_display_(Seq[Any](format.raw/*30.94*/("""selected""")))}),format.raw/*30.103*/(""" """),format.raw/*30.104*/("""value=""""),_display_(/*30.112*/action/*30.118*/.id),format.raw/*30.121*/("""">"""),_display_(/*30.124*/action/*30.130*/.name),format.raw/*30.135*/("""</option>
                        """)))}),format.raw/*31.26*/("""
                        """),format.raw/*32.25*/("""</select>
                    </div>
                </div>

                <div class="clearfix form-actions">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">"""),_display_(/*38.72*/Messages("btn.update")),format.raw/*38.94*/("""</button>
                            &nbsp;
                        <a class="btn" type="reset" href='"""),_display_(/*40.60*/routes/*40.66*/.App.calendar(returnDate)),format.raw/*40.91*/("""'>"""),_display_(/*40.94*/Messages("btn.back")),format.raw/*40.114*/("""</a>
                    </div>
                </div>
            """)))}),format.raw/*43.14*/("""

        """),format.raw/*45.9*/("""</div>
    </div>
""")))}/*47.2*/ {_display_(Seq[Any](format.raw/*47.4*/("""
    """),format.raw/*48.5*/("""<script src='"""),_display_(/*48.19*/routes/*48.25*/.Assets.at("js/installationEdit.js")),format.raw/*48.61*/("""'></script>
""")))}))}
  }

  def render(eventId:String,allDay:Boolean,eventForm:Form[dto.EventTO],upcomingActions:dto.EventsContainer,returnDate:String): play.twirl.api.HtmlFormat.Appendable = apply(eventId,allDay,eventForm,upcomingActions,returnDate)

  def f:((String,Boolean,Form[dto.EventTO],dto.EventsContainer,String) => play.twirl.api.HtmlFormat.Appendable) = (eventId,allDay,eventForm,upcomingActions,returnDate) => apply(eventId,allDay,eventForm,upcomingActions,returnDate)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Apr 08 17:32:51 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/event/editInstallation.scala.html
                  HASH: 0975a29d4d7cbbca1ea77457be30cf063970f80a
                  MATRIX: 793->1|1004->123|1034->128|1046->133|1103->182|1114->185|1153->187|1173->190|1211->192|1243->198|1319->248|1369->278|1405->288|1524->380|1563->410|1603->412|1649->430|1727->481|1741->486|1775->499|1821->517|1873->538|1917->555|1932->561|2053->672|2094->674|2142->695|2156->700|2242->765|2290->785|2419->887|2471->917|2631->1050|2649->1059|2695->1083|2751->1112|2805->1150|2845->1152|2903->1182|2939->1191|3003->1246|3042->1247|3083->1256|3113->1257|3149->1265|3165->1271|3190->1274|3221->1277|3237->1283|3264->1288|3331->1324|3385->1350|3646->1584|3689->1606|3822->1712|3837->1718|3883->1743|3913->1746|3955->1766|4057->1837|4096->1849|4135->1870|4174->1872|4207->1878|4248->1892|4263->1898|4320->1934
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|32->4|33->5|35->7|35->7|36->8|42->14|42->14|42->14|43->15|44->16|44->16|44->16|45->17|46->18|48->20|48->20|48->20|48->20|50->22|50->22|50->22|52->24|53->25|53->25|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|59->31|60->32|66->38|66->38|68->40|68->40|68->40|68->40|68->40|71->43|73->45|75->47|75->47|76->48|76->48|76->48|76->48
                  -- GENERATED --
              */
          