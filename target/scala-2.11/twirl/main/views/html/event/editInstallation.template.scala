
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
object editInstallation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,Boolean,Form[dto.EventTO],dto.ActionsContainer,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(eventId: String, allDay: Boolean, eventForm: Form[dto.EventTO], upcomingActions: dto.ActionsContainer, returnDate: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.125*/("""

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

  def render(eventId:String,allDay:Boolean,eventForm:Form[dto.EventTO],upcomingActions:dto.ActionsContainer,returnDate:String): play.twirl.api.HtmlFormat.Appendable = apply(eventId,allDay,eventForm,upcomingActions,returnDate)

  def f:((String,Boolean,Form[dto.EventTO],dto.ActionsContainer,String) => play.twirl.api.HtmlFormat.Appendable) = (eventId,allDay,eventForm,upcomingActions,returnDate) => apply(eventId,allDay,eventForm,upcomingActions,returnDate)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Mar 12 14:28:07 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/event/editInstallation.scala.html
                  HASH: 5f588bc67593f5d45a23f90ed4d08bc183ba9d10
                  MATRIX: 794->1|1006->124|1036->129|1048->134|1105->183|1116->186|1155->188|1175->191|1213->193|1245->199|1321->249|1371->279|1407->289|1526->381|1565->411|1605->413|1651->431|1729->482|1743->487|1777->500|1823->518|1875->539|1919->556|1934->562|2055->673|2096->675|2144->696|2158->701|2244->766|2292->786|2421->888|2473->918|2633->1051|2651->1060|2697->1084|2753->1113|2807->1151|2847->1153|2905->1183|2941->1192|3005->1247|3044->1248|3085->1257|3115->1258|3151->1266|3167->1272|3192->1275|3223->1278|3239->1284|3266->1289|3333->1325|3387->1351|3648->1585|3691->1607|3824->1713|3839->1719|3885->1744|3915->1747|3957->1767|4059->1838|4098->1850|4137->1871|4176->1873|4209->1879|4250->1893|4265->1899|4322->1935
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|32->4|33->5|35->7|35->7|36->8|42->14|42->14|42->14|43->15|44->16|44->16|44->16|45->17|46->18|48->20|48->20|48->20|48->20|50->22|50->22|50->22|52->24|53->25|53->25|56->28|56->28|56->28|57->29|57->29|57->29|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|58->30|59->31|60->32|66->38|66->38|68->40|68->40|68->40|68->40|68->40|71->43|73->45|75->47|75->47|76->48|76->48|76->48|76->48
                  -- GENERATED --
              */
          